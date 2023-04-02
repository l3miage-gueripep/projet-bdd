package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import fr.uga.l3miage.photonum.data.repo.ClientRepository;
import fr.uga.l3miage.photonum.data.repo.ImpressionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class ImpressionServiceImpl implements ImpressionService {

    private final ImpressionRepository impressionRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public ImpressionServiceImpl(ClientRepository clientRepository, ImpressionRepository impressionRepository) {
        this.impressionRepository = impressionRepository;
        this.clientRepository = clientRepository;
    }


    @Override
    public Impression save(Long clientId, Impression impression) throws EntityNotFoundException {
        impressionRepository.save(impression);
        bind(clientId, impression);
        return impression;
    }

    @Override
    public Impression get(Long id) throws EntityNotFoundException {
        return impressionRepository.get(id);
    }

    @Override
    public Collection<Impression> list() {
        return impressionRepository.all();
    }

    @Override
    public Impression update(Impression object) throws EntityNotFoundException {
        return null;
    }

    @Override
    public Collection<Impression> searchByid(String query) {
        // TODO Auto-generated method stub
        return null;
    }


    private void bind(Long clientId, Impression impression) throws EntityNotFoundException {
        Client client = clientRepository.get(clientId);
        client.addImpression(impression);
        impression.setCommanditaire(client);
    }


   
}
