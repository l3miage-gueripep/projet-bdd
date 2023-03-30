package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class AdresseRepository implements CRUDRepository<Long, Adresse> {
    @PersistenceContext
    private EntityManager entityManager;
    CriteriaBuilder cb;

    @Autowired
    public AdresseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.cb = this.entityManager.getCriteriaBuilder();
    }

    @Override
    public  Adresse save(Adresse adresse){
        entityManager.persist(adresse);
        return adresse;
    }
    @Override
    public Adresse get(Long id) {
        return entityManager.find(Adresse.class, id);
    }


    @Override
    public void delete(Adresse adresse) {
        entityManager.remove(adresse);
    }
    @Override
    public List<Adresse> all() {
        CriteriaQuery<Adresse> query = this.cb.createQuery(Adresse.class);
        Root<Adresse> root = query.from(Adresse.class); //necessaire pour ne pas avoir de bug à l'execution meme si pas utilisé
        //return
        return this.entityManager.createQuery(query).getResultList();
    }
}
