package fr.uga.l3miage.photonum.data.domain;

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
    //Album [1]

    // constructors, getters, and setters
}