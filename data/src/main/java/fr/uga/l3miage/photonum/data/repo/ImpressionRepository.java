package fr.uga.l3miage.photonum.data.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;

import java.util.List;

@Repository
public class ImpressionRepository implements CRUDRepository<Long, Impression> {

    @PersistenceContext
    private EntityManager entityManager;
    CriteriaBuilder cb;

    @Autowired
    public ImpressionRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.cb = this.entityManager.getCriteriaBuilder();
    }

    @Override
    public Impression save(Impression impression) {
        entityManager.persist(impression);
        return impression;

    }

    @Override
    public Impression get(Long id) {
        return entityManager.find(Impression.class, id);
    }


    @Override
    public void delete(Impression impression) {
        entityManager.remove(impression);
    }


    @Override
    public List<Impression> all() {
        CriteriaQuery<Impression> query = this.cb.createQuery(Impression.class);
        Root<Impression> root = query.from(Impression.class); //necessaire pour ne pas avoir de bug à l'execution meme si pas utilisé
        //return
        return this.entityManager.createQuery(query).getResultList();
    }

}
