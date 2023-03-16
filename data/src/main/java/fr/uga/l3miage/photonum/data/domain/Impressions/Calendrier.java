package fr.uga.l3miage.photonum.data.domain.Impressions;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="calendrier")
public class Calendrier extends Impression {
    //associations
    @OneToMany
    private List<Page> pages = new ArrayList<>();
    
}
