package fr.uga.l3miage.photonum.data.repo;

import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.data.repo.Exceptions.EchecSupressionException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhotoRepository implements CRUDRepository<Long, Photo>{

    private final EntityManager entityManager;
    CriteriaBuilder cb;

    @Autowired
    public PhotoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.cb = this.entityManager.getCriteriaBuilder();
    }

    @Override
    public Photo save(Photo photo) {
        entityManager.persist(photo);
        return photo;
    }

    @Override
    public Photo get(Long id) {
        return entityManager.find(Photo.class, id);
    }

    @Override
    public void delete(Photo entity) throws EchecSupressionException {

    }

    @Override
    public List<Photo> all() {
        CriteriaQuery<Photo> query = this.cb.createQuery(Photo.class);
        Root<Photo> root = query.from(Photo.class); //necessaire pour ne pas avoir de bug à l'execution meme si pas utilisé
        //return
        return this.entityManager.createQuery(query).getResultList();
    }
}
