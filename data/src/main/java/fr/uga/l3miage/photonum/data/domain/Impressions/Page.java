package fr.uga.l3miage.photonum.data.domain.Impressions;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.ArrayList;
import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Photo;
import jakarta.persistence.*;

@Entity
@Table(name="page")
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_page")
    private int numPage;

    //associations
    @OneToMany
    private List<Photo> photos = new ArrayList<>();

    //tirage
    @ManyToOne
    private Album album;
    //calendrier
    @ManyToOne
    private Calendrier calendrier;
    //cadre

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public int getNumPage() {
        return numPage;
    }
    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }
    public List<Photo> getPhotos() {
        return photos;
    }
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
    public Album getAlbum() {
        return album;
    }
    public void setAlbum(Album album) {
        this.album = album;
    }
    public Calendrier getCalendrier() {
        return calendrier;
    }
    public void setCalendrier(Calendrier calendrier) {
        this.calendrier = calendrier;
    }
    




}
