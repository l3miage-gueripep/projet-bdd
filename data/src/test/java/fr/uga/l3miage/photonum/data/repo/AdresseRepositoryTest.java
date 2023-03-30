package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import jakarta.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

public class AdresseRepositoryTest extends Base{
    @Autowired
    EntityManager entityManager;

    @Autowired
    AdresseRepository adresseRepository;


    @Test
    void saveAdresseTest() {

        Adresse a1 = Fixtures.newAdresse();
        adresseRepository.save(a1);

        entityManager.flush();

        entityManager.detach(a1);

        List<Adresse> adresses = adresseRepository.all();
        assertThat(adresses)
            .hasSize(1);
        
    }
    


}
