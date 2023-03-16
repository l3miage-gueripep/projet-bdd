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

    @ManyToOne
    private Calendrier calendrier;

    //cadre




}
