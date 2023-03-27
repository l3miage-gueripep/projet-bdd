package fr.uga.l3miage.photonum.data.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
    //lien avec client
    @ManyToOne
    private Article articles;


    // getters, and setters
    @ManyToMany
    private List<Article> articles = new ArrayList<>();

    // constructors, getters, and setters
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public Float getPrixTotal(){
        return prixTotal;
    }
    public void setPrixTotal(Float prixTotal){
        this.prixTotal= prixTotal;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    
}
