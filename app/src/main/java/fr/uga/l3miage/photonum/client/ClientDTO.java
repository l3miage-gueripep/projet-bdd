package fr.uga.l3miage.photonum.client,

import java.util.List,

import fr.uga.l3miage.photonum.data.domain.Article,
import fr.uga.l3miage.photonum.data.domain.Client,
import fr.uga.l3miage.photonum.data.domain.Photo,
import jakarta.validation.constraints.NotBlank,
import jakarta.validation.constraints.NotEmpty,

public record ClientDTO(
    
    Long id,

    @NotBlank(message = "le nom de l'impression ne peut pas être vide")
    String email,
    
    @NotBlank(message = "le mot de passe de l'impression ne peut pas être vide")
    String password,
    
    String firstName,
    
    String lastName,
    
    String address
    
) {
}
