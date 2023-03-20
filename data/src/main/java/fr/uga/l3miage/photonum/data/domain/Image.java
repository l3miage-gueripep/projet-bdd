package fr.uga.l3miage.photonum.data.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "emplacement")
    private String emplacement;
    
    @Column(name = "infos")
    private String infos;
    
    @Column(name = "resolution")
    private Integer resolution;
    
    @Column(name = "partage")
    private Boolean partage;
    
    //lien :
    //photos
    @OneToMany(mappedBy = "image")
    private List<Photo> images = new ArrayList<>();
    //client
    @ManyToOne
    @JoinColumn(name = "proprietaire_id")
    private Client proprietaire;

    // getters, and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmplacement() {
        return emplacement;
    }
    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getInfos() {
        return infos;
    }
    public void setInfos(String infos) {
        this.infos = infos;
    }
    public Integer getResolution() {
        return resolution;
    }
    public void setResolution(Integer resolution) {
        this.resolution = resolution;
    }

    public Boolean getPartage() {
        return partage;
    }
    public void setPartage(Boolean partage) {
        this.partage = partage;
    }

    public List<Photo> getImages() {
        return images;
    }
    public void setImages(List<Photo> images) {
        this.images = images;
    }
    
    public Client getProprietaire() {
        return proprietaire;
    }
    public void setProprietaire(Client proprietaire) {
        this.proprietaire = proprietaire;
    }

    
    
}
