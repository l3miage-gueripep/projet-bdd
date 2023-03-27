package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.h2.mvstore.cache.FilePathCache.FileCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import fr.uga.l3miage.photonum.data.repo.ImageRepository;
import fr.uga.l3miage.photonum.data.repo.Exceptions.EchecSupressionException;
import jakarta.persistence.EntityManager;


import static org.assertj.core.api.Assertions.assertThat;

public class ImageRepositoryTest extends Base  {
    @Autowired
    EntityManager entityManager;

    @Autowired
    ImageRepository imageRepository;

    @Test
    void deleteImage() {
        Image img1 = Fixtures.newImage(); //erreur a une photo qui a une impression
        Image img2 = Fixtures.newImage(); //erreur est partagé
        Image img3 = Fixtures.newImage(); //fonctionne avec une photo sans impression
        Image img4 = Fixtures.newImage(); //fonctionne avec rien
        entityManager.persist(img1);
        entityManager.persist(img2);
        entityManager.persist(img3);
        entityManager.persist(img4);

        img2.setPartage(true);
        //create photo
        Photo ph1 = Fixtures.newPhoto();
        Photo ph2 = Fixtures.newPhoto();
        entityManager.persist(ph1);
        entityManager.persist(ph2);

        img1.addPhoto(ph1);
        img3.addPhoto(ph2);

        //create impressions
        Impression i1 = Fixtures.newImpression();
        entityManager.persist(i1);

        ph1.addImpression(i1);


        //synchronize with the database
        entityManager.flush();




        try{
            imageRepository.delete(img1);
        }
        catch(EchecSupressionException e){
            System.out.println("image 1 non supprimée");
        }

        try{
            imageRepository.delete(img2);
        }
        catch(EchecSupressionException e){
            System.out.println("image 2 non supprimée");
        }
        try{
            imageRepository.delete(img3);
        }
        catch(EchecSupressionException e){
            System.out.println("image 3 non supprimée");
        }
        try{
            imageRepository.delete(img4);
            System.out.println("try de supprimer l'image 4");
        }
        catch(EchecSupressionException e){
            System.out.println("image 4 non supprimée");
        }

        //detach the elements from the database
        entityManager.detach(img1);
        entityManager.detach(img2);
        entityManager.detach(img3);
        entityManager.detach(img4);
        entityManager.detach(ph1);
        entityManager.detach(ph2);
        entityManager.detach(i1);

        
        List<Image> images = imageRepository.all();
        assertThat(images)
                .hasSize(2);



    }
}
