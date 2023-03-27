package fr.uga.l3miage.photonum.data.domain;

import java.util.ArrayList;
import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    
    @Id
    private Long email;
    
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
    //impression
    @OneToMany(mappedBy = "commanditaire")
    private List<Impression> impressions = new ArrayList<>();
    // constructors, getters, and setters

    //methods
    public void telecharger(){
        //todo?
    }
    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
   public String getPassword (){
    return password;
   }
   public void setPassWord(String password){
    this.password = password;
   }
   public String getFirstName(){
     return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getAdress(){
        return address;
    }
    public void setAdress(String adress){
           this.address = adress;
    }
    public List<Commande> getCommandes() {
        return commandes;
    }
    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
    public List<Adresse> getAdresses() {
        return adresses;
    }
    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }
    public List<Impression> getImpressions() {
        return impressions;
    }
    public void setImpressions(List<Impression> impressions) {
        this.impressions = impressions;
    }


    
}
