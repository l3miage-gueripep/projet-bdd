package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Impressions.Cadre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CadreRepository implements CRUDRepository<Long, Cadre>{
   
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public  Cadre save(Cadre entity){
        entityManager.persist(entity);
        return entity;
    }
    @Override
    public Cadre get(Long id) {
        return entityManager.find(Cadre.class, id);
    }


    @Override
    public void delete(Cadre cadre) {
        entityManager.remove(cadre);
    }
    @Override
    public List<Cadre> all() {
        return entityManager.createQuery("FROM Cadre ").getResultList();
    }
}
