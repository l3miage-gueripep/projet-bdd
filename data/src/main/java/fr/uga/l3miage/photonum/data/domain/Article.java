package fr.uga.l3miage.photonum.data.domain;

import java.util.*;

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
    
    @ManyToMany(mappedBy = "articles")
    private List<Commande> commandes = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "catalogue_id", nullable = false)
    private Catalogue catalogue;
    
    // constructors, getters, and setters
}
