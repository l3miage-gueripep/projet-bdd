package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "emplacement")
    private String emplacement;
    
    @Column(name = "infos")
    private String infos;
    
    @Column(name = "resolution")
    private Integer resolution;
    
    @Column(name = "partage")
    private Boolean partage;
    
    //lien :
    //photos
    //client
    @ManyToOne
    @JoinColumn(name = "proprietaire_id")
    private Client proprietaire;


    // constructors, getters, and setters
}
