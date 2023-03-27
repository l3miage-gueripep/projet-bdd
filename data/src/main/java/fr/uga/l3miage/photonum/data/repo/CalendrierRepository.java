package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Impressions.Calendrier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CalendrierRepository implements CRUDRepository<Long, Calendrier> {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public  Calendrier save(Calendrier entity){
        entityManager.persist(entity);
        return entity;
    }
    @Override
    public Calendrier get(Long id) {
        return entityManager.find(Calendrier.class, id);
    }


    @Override
    public void delete(Calendrier calendrier) {
        entityManager.remove(calendrier);
    }
    @Override
    public List<Calendrier> all() {
        return null;
    }
    
}
