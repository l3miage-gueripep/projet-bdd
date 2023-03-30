package fr.uga.l3miage.photonum.commande;

import java.sql.Date;

import ch.qos.logback.core.net.server.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;

public class CommandeDTO {
    
    private Long id;
    @NotBlank
    private Date date;

    private Float prixTotal;

    @Null
    Client clients;
}
