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
    private Client commanditaire;
    //photo
    @ManyToOne
    private Photo photo;
    
      // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public List<Article> getArticles() {
        return articles;
    }
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    public Client getCommanditaire() {
        return commanditaire;
    }
    public void setCommanditaire(Client commanditaire) {
        this.commanditaire = commanditaire;
    }
    public Photo getPhoto() {
        return photo;
    }
    public void setPhoto(Photo photo) {
        this.photo = photo;
    }


}