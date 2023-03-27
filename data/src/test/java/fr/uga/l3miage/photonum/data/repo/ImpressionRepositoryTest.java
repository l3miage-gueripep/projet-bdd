package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import jakarta.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;


class ImpressionRepositoryTest extends Base {

    @Autowired
    EntityManager entityManager;

    @Autowired
    ImpressionRepository impressionRepository;

    @Test
    void getAllImpressions() {
        String nom1 = "Ma premiere impression";
        String nom2 = "Ma deuxieme impression";

        //create impressions
        Impression i1 = Fixtures.newImpression();
        i1.setNom(nom1);
        Impression i2 = Fixtures.newImpression();
        i2.setNom(nom2);


        //save in the database
        entityManager.persist(i1);
        entityManager.persist(i2);

        //synchronize with the database
        entityManager.flush();

        //detach the elements from the database
        entityManager.detach(i1);
        entityManager.detach(i2);

        List<Impression> impressions = impressionRepository.all();
        assertThat(impressions)
                .hasSize(2)
                .extracting("nom")
                .containsExactly(nom1, nom2);


    }

}
