package fr.uga.l3miage.photonum.data.domain.Impressions;

import java.util.ArrayList;
import java.util.List;


import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Photo;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Impression {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;

    protected String nom;
    //associations
    @OneToMany
    private List<Article> articles = new ArrayList<>();
    //client
    @ManyToOne
    private Client client;
    //photo
    @ManyToOne
    private Photo photo;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Article> getArticles() {
        return this.articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Photo getPhoto() {
        return this.photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    // getters and setters
    
}