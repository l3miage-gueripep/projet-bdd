package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "catalogues")
public class Catalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="reference")
    @Enumerated(EnumType.STRING)
    private Reference reference;
}

