package fr.uga.l3miage.photonum.data.domain.Impressions;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Article> articles = new ArrayList<>();
    //client
    @ManyToOne(fetch = FetchType.EAGER)
    private Client commanditaire;
    //photo

    @ManyToMany
    private List<Photo> photos = new ArrayList<>();
    
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
//    public List<Article> getArticles() {
//        return articles;
//    }
//    public void setArticles(List<Article> articles) {
//        this.articles = articles;
//    }
    public Client getCommanditaire() {
        return commanditaire;
    }
    public void setCommanditaire(Client commanditaire) {
        this.commanditaire = commanditaire;
    }
    public List<Photo> getPhotos() {
        return photos;
    }
    public void addPhoto(Photo photo) {
        this.photos.add(photo);
    }


}