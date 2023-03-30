package fr.uga.l3miage.photonum.data.domain.Impressions;

import jakarta.persistence.*;

@Entity
@Table(name = "albums")
public class Album extends Impression{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Couverture couverture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Couverture getCouverture() {
        return couverture;
    }

    public void setCouverture(Couverture couverture) {
        this.couverture = couverture;
    }

    

}
