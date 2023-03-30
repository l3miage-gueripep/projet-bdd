package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.repo.ClientRepository;


@Service
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client get(Long id) throws EntityNotFoundException {
        return clientRepository.get(id);
    }

    @Override
    public Collection<Client> list() {
        return clientRepository.all();
    }

    @Override
    public Client update(Client client) throws EntityNotFoundException {
        return clientRepository.save(client);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Collection<Client> searchByid(String query) {
        return clientRepository.searchByid(query);
    }

    
}
