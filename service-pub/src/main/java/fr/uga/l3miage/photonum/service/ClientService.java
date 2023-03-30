package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.service.base.BaseService;

@Service
public interface ClientService extends BaseService<Client, Long> {

    Client save(Client client);

    Collection<Client> searchByid(String query);


}