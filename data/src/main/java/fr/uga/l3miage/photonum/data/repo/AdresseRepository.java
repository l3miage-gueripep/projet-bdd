package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AdresseRepository implements CRUDRepository<Long, Adresse> {
    @PersistenceContext
    private EntityManager entityManager;

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
        return null;
    }
}