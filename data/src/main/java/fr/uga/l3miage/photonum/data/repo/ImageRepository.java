package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Image;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class ImageRepository implements CRUDRepository<Long, Image>{

    private final EntityManager entityManager;
    CriteriaBuilder cb;

    @Autowired
    public ImageRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.cb = this.entityManager.getCriteriaBuilder();
    }
    
    @Override
    public List<Image> all() {
        CriteriaQuery<Image> query = this.cb.createQuery(Image.class);
        Root<Image> root = query.from(Image.class);
        
        //predicate
        query.orderBy(cb.asc(root.get("fullName")));

        //return
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(Image image) {
        if(image.getPartage())
        entityManager.remove(image);
        
    }

    @Override
    public Image get(Long id) {
        return entityManager.find(Image.class, id);
    }

    @Override
    public Image save(Image image) {
        entityManager.persist(image);
        return image;
    }
}
