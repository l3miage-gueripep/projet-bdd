package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Impressions.Couverture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CouvertureRepository implements CRUDRepository<Long, Couverture> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Couverture save(Couverture entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Couverture get(Long id) {
        return entityManager.find(Couverture.class, id);
    }


    @Override
    public void delete(Couverture couverture) {
        entityManager.remove(couverture);
    }


    @Override
    public List<Couverture> all() {
        return null;
    }
    
}
