package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="adresse")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="code_postal")
    private int codePostal;

    @Column(name="rue")
    private String rue;
}
