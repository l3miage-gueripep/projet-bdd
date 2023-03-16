package fr.uga.l3miage.photonum.data.domain;

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

    //lien avec image

    // constructors, getters, and setters
}
