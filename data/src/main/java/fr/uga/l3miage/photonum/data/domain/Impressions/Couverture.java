package fr.uga.l3miage.photonum.data.domain.Impressions;

import fr.uga.l3miage.photonum.data.domain.Photo;
import jakarta.persistence.*;

@Entity
@Table(name = "couvertures")
public class Couverture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre")
    private String titre;

    //liens
    //photo [1]
    @OneToOne
    private Photo photo;
    //Album [1]
    @OneToOne
    private Album album;
    // constructors, getters, and setters
}