package fr.uga.l3miage.photonum.data.domain.Impressions;

import java.util.ArrayList;
import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Photo;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cadre")
public class Cadre extends Impression{
    @OneToMany
    private List<Photo> photos = new ArrayList<>();
}
