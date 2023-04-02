package fr.uga.l3miage.photonum.data.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "emplacement")
    private String emplacement;
    
    @Column(name = "infos")
    private String infos;
    
    @Column(name = "resolution")
    private Integer resolution;
    
    @Column(name = "partage")
    private Boolean partage;
    
    //images
    @JsonIgnore
    @OneToMany(mappedBy = "image")
    private List<Photo> photos = new ArrayList<>();
    //client
    @ManyToOne
    @JoinColumn(name = "proprietaire")
    private Client proprietaire;

    public Image(){
        this.partage = false;
    }

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
    public void setPartage(Boolean partage){
        this.partage = partage;
    }

    public List<Photo> getPhotos() {
        return this.photos;
    }
    public void addPhoto(Photo photo) {
        this.photos.add(photo);
    }
    
     public Client getProprietaire() {
         return proprietaire;
     }
     public void setProprietaire(Client proprietaire) {
         this.proprietaire = proprietaire;
     }

    
    
}
