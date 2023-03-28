package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClientRepository implements CRUDRepository<Long, Client> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public  Client save(Client entity){
        entityManager.persist(entity);
        return entity;
    }
    @Override
    public Client get(Long email) {
        return entityManager.find(Client.class, email);
    }


    @Override
    public void delete(Client client) {
        entityManager.remove(client);
    }
    @Override
    public List<Client> all() {
        return null;
    }



    // détails de la commande d'un client avec son statut, 
    // les informations d'un compte client, la liste des impressions d'un client avec possibilité de 
    // détailler le contenu, la liste des images partagées. 
    
    
}
