package fr.uga.l3miage.photonum.data.domain;

import java.util.ArrayList;
import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Impressions.Cadre;
import fr.uga.l3miage.photonum.data.domain.Impressions.Couverture;
import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import fr.uga.l3miage.photonum.data.domain.Impressions.Page;
import fr.uga.l3miage.photonum.data.domain.Impressions.Tirage;
import jakarta.persistence.*;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parametres")
    private String parametres;

    @Column(name = "texte_descriptif")
    private String texteDescriptif;

//associations
    @OneToMany 
    private List<Impression> impressions = new ArrayList<>();
    //lien avec image
    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;
    //tirage
    @ManyToOne
    @JoinColumn(name = "tirage_id")
    private Tirage tirage;
    //cadre
    @ManyToOne
    @JoinColumn(name = "cadre_id")
    private Cadre cadre;

    //page
    @ManyToOne
    @JoinColumn(name = "page_id")
    private Page page;

    //couverture
    @OneToOne
    private Couverture couverture;
    // constructors, getters, and setters
}
