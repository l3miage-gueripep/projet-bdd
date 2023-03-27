package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.data.repo.Exceptions.EchecSupressionException;
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
    public void delete(Image image) throws EchecSupressionException {
        if(image.getPartage()){
            throw new EchecSupressionException("On ne peut pas supprimer une image partagée");
        }
        if(image.getPhotos().size() > 0){
            for(Photo photo : image.getPhotos()){
                if(photo.getImpressions().size() > 0){
                    throw new EchecSupressionException("Echec de la suppression: une impression est liée à l'une des photos de cette image");
                }
            }
        }

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


