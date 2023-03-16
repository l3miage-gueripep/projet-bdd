package fr.uga.l3miage.photonum.data.domain.Impressions;

import java.util.ArrayList;
import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Photo;
import jakarta.persistence.*;

@Entity
@Table(name="tirage")
public class Tirage extends Impression{
    @OneToMany
    private List<Photo> photos = new ArrayList<>();
}
