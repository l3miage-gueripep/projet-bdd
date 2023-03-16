package fr.uga.l3miage.photonum.data.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "address")
    private String address;

    //lien avec images
    @OneToMany(mappedBy = "proprietaire")
    private List<Image> images = new ArrayList<>();
    //lien avec commandes
    @OneToMany(mappedBy = "client")
    private List<Commande> commandes = new ArrayList<>();
    //lien avec adresse
    @OneToMany(mappedBy = "proprietaire")
    private List<Adresse> adresses = new ArrayList<>();
    // constructors, getters, and setters

    //methods
    public void telecharger(){
        //todo?
    }
}
