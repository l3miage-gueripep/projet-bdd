package fr.uga.l3miage.photonum.data.domain;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "image")
    private List<Photo> images = new ArrayList<>();
    //client
    @ManyToOne
    @JoinColumn(name = "proprietaire_id")
    private Client proprietaire;



    // constructors, getters, and setters
}
