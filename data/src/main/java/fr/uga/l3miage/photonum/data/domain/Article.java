package fr.uga.l3miage.photonum.data.domain;

import java.util.*;

import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import jakarta.persistence.*;

@Entity
@Table(name="articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Float prix;
    
    @Column(nullable = false)
    private int quantite;
    
    //associations

    @OneToOne
    @JoinColumn(name = "catalogue_id")
    private Catalogue catalogue;

    
    @ManyToMany(mappedBy = "articles")
    private List<Commande> commandes = new ArrayList<>();

    //impression
    @ManyToOne
    private Impression impression;
    
    // constructors, getters, and setters
}
