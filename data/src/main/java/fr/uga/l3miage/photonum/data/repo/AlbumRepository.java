package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Impressions.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AlbumRepository  implements CRUDRepository<Long, Album> {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public  Album save(Album entity){
        entityManager.persist(entity);
        return entity;
    }
    @Override
    public Album get(Long id) {
        return entityManager.find(Album.class, id);
    }


    @Override
    public void delete(Album album) {
        entityManager.remove(album);
    }
    @Override
    public List<Album> all() {
        return entityManager.createQuery("FROM Album").getResultList();
    }
    
}
