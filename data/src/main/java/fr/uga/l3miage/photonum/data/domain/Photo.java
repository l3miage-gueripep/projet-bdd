package fr.uga.l3miage.photonum.data.domain;

import java.util.ArrayList;
import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Impressions.Cadre;
import fr.uga.l3miage.photonum.data.domain.Impressions.Couverture;
import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import fr.uga.l3miage.photonum.data.domain.Impressions.Page;
import fr.uga.l3miage.photonum.data.domain.Impressions.Tirage;
import jakarta.persistence.*;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parametres")
    private String parametres;

    @Column(name = "texte_descriptif")
    private String texteDescriptif;

//associations
    @ManyToMany 
    private List<Impression> impressions = new ArrayList<>();
    //lien avec image
    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;
    //tirage
    @ManyToOne
    @JoinColumn(name = "tirage_id")
    private Tirage tirage;
    //cadre
    @ManyToOne
    @JoinColumn(name = "cadre_id")
    private Cadre cadre;

    //page
    @ManyToOne
    @JoinColumn(name = "page_id")
    private Page page;

    //couverture
    @OneToOne
    private Couverture couverture;
    // getters, and setters

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParametres() {
        return parametres;
    }

    public void setParametres(String parametres) {
        this.parametres = parametres;
    }

    public String getTexteDescriptif() {
        return texteDescriptif;
    }

    public void setTexteDescriptif(String texteDescriptif) {
        this.texteDescriptif = texteDescriptif;
    }

    public List<Impression> getImpressions() {
        return impressions;
    }

    public void addImpression(Impression impression) {
        this.impressions.add(impression);
        impression.addPhoto(this);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Tirage getTirage() {
        return tirage;
    }

    public void setTirage(Tirage tirage) {
        this.tirage = tirage;
    }

    public Cadre getCadre() {
        return cadre;
    }

    public void setCadre(Cadre cadre) {
        this.cadre = cadre;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Couverture getCouverture() {
        return couverture;
    }

    public void setCouverture(Couverture couverture) {
        this.couverture = couverture;
    }
    
}
