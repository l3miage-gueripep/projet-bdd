package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="adresse")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="code_postal")
    private int codePostal;

    @Column(name="rue")
    private String rue;
    //getters et setters

    // @ManyToOne
    // @JoinColumn(name = "proprietaire_id")
    // private Client proprietaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }
    
}
