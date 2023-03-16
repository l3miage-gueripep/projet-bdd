package fr.uga.l3miage.photonum.data.domain.Impressions;

import jakarta.persistence.*;

@Entity
@Table(name = "albums")
public class Album extends Impression{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Couverture couverture;


}
