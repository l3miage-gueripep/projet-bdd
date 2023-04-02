package fr.uga.l3miage.photonum.data.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "firstname")
    private String firstname;
    
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "address")
    private String address;

    //lien avec images
    @JsonIgnore
    @OneToMany(mappedBy = "proprietaire")
    private List<Image> images = new ArrayList<>();
    //lien avec commandes
    // @OneToMany(mappedBy = "client")
    // private List<Commande> commandes = new ArrayList<>();
    //lien avec adresse
    // @OneToMany(mappedBy = "proprietaire")
    // private List<Adresse> adresses = new ArrayList<>();
    //impression
    @JsonIgnore
    @OneToMany(mappedBy = "commanditaire")
    private List<Impression> impressions = new ArrayList<>();
    // constructors, getters, and setters

    //methods
    // public void telecharger(){
    //     //todo?
    // }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

     public List<Image> getImages() {
         return images;
     }

     public void setImages(List<Image> images) {
         this.images = images;
     }

     public void addImage(Image image){
        this.images.add(image);
     }

    // public List<Commande> getCommandes() {
    //     return commandes;
    // }

    // public void setCommandes(List<Commande> commandes) {
    //     this.commandes = commandes;
    // }

    // public List<Adresse> getAdresses() {
    //     return adresses;
    // }

    // public void setAdresses(List<Adresse> adresses) {
    //     this.adresses = adresses;
    // }

    public List<Impression> getImpressions() {
        return impressions;
    }

    public void setImpressions(List<Impression> impressions) {
        this.impressions = impressions;
    }

    public void addImpression(Impression impression){
        this.impressions.add(impression);
    }
}
