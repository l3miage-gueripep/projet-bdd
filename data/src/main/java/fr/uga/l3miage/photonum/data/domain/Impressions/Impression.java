package fr.uga.l3miage.photonum.data.domain.Impressions;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Impression {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;

    protected String nom;

    public Impression() {
        // default constructor
    }

    public Impression(String nom) {
        this.nom = nom;
    }

    // getters and setters
}