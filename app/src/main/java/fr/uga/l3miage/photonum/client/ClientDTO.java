package fr.uga.l3miage.photonum.client;

import jakarta.validation.constraints.NotBlank;

public record ClientDTO(
    
    Long id,
    
    @NotBlank(message = "un email ne doit pas être vide")
    String email,
    
    String firstname,
    String lastname,

    @NotBlank(message = "une adresse ne doit pas être vide")
    String adress
) {
}
