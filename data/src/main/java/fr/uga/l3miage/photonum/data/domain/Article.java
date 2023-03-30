package fr.uga.l3miage.photonum.data.domain;

import java.util.*;

import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import jakarta.persistence.*;

@Entity
@Table(name="articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private Float prix;
    
    @Column(nullable = false)
    private int quantite;
    
    //associations

    @OneToOne
    @JoinColumn(name = "catalogue_id")
    private Catalogue catalogue;
    
    @ManyToMany(mappedBy = "articles")
    private List<Commande> commandes = new ArrayList<>();

    //impression
    @ManyToOne
    private Impression impression;
    
    // constructors, getters, and setters
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public Float getPrix(){
        return prix;
    }
    public void setPrix(Float prix){
        this.prix = prix;
    }
    public int getQuantite(){
        return quantite;
    }
    public void setQuantite(int quantite){
        this.quantite = quantite;
    }
    public Catalogue getCatalogue() {
        return catalogue;
    }
    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }
    public List<Commande> getCommandes() {
        return commandes;
    }
    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
    public Impression getImpression() {
        return impression;
    }
    public void setImpression(Impression impression) {
        this.impression = impression;
    }
    
}
