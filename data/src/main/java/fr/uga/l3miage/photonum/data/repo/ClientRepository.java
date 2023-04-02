package fr.uga.l3miage.photonum.data.repo;

import java.util.Collection;
import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClientRepository implements CRUDRepository<Long, Client> {
    @PersistenceContext
    private EntityManager entityManager;

    private CriteriaBuilder cb;

    @Autowired
    public ClientRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.cb = this.entityManager.getCriteriaBuilder();
    }


    @Override
    public  Client save(Client entity){
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Client get(Long id) {
        return entityManager.find(Client.class, id);
    }

    public Collection<Client> searchByid(String query) {
        return entityManager.createQuery("from Client a where a.id = :id order by a.id", Client.class)
                .setParameter("id", query)
                .getResultList();
    }


    @Override
    public void delete(Client client) {
        entityManager.remove(client);
    }
    @Override
    public List<Client> all() {
        CriteriaQuery<Client> query = this.cb.createQuery(Client.class);
        Root<Client> root = query.from(Client.class); //necessaire pour ne pas avoir de bug à l'execution meme si pas utilisé
        //return
        return this.entityManager.createQuery(query).getResultList();
    }


    public void deleteAll(){
        //deletes all existing clients
        CriteriaDelete<Client> deleteQuery = cb.createCriteriaDelete(Client.class);
        Root<Client> root = deleteQuery.from(Client.class);
        deleteQuery.where(cb.isNotNull(root.get("id")));
        entityManager.createQuery(deleteQuery).executeUpdate();
    }


    // détails de la commande d'un client avec son statut, 
    // les informations d'un compte client, la liste des impressions d'un client avec possibilité de 
    // détailler le contenu, la liste des images partagées. 
    
    
}
