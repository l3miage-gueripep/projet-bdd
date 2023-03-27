package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Reference;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ReferenceRepository implements CRUDRepository<Long, Reference>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Reference save(Reference reference) {
        entityManager.persist(reference);
        return reference;
    }

    @Override
    public Reference get(Long id) {
        return entityManager.find(Reference.class, id);
    }


    @Override
    public void delete(Reference impression) {
        entityManager.remove(impression);
    }


    @Override
    public List<Reference> all() {
        return null;
    }

}