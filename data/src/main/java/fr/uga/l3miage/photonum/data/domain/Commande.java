package fr.uga.l3miage.photonum.data.domain;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "commands")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "prix_total")
    private Float prixTotal;

    //lien avec client
    @ManyToOne
    private Client client;

    // constructors, getters, and setters
}
