package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "catalogues")
public class Catalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="reference")
    @Enumerated(EnumType.STRING)
    private Reference reference;

    @OneToOne
    @JoinColumn(name = "article_id")
    private Article article;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    
}

