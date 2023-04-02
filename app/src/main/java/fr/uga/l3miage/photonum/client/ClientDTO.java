package fr.uga.l3miage.photonum.client;

import java.util.Collection;

import fr.uga.l3miage.photonum.impression.ImpressionDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;

public record ClientDTO(
        Long id,
        @NotBlank(message = "un email ne doit pas être vide")
        String email,
        @NotBlank(message = "un firstname ne doit pas être vide")
        String firstname,
        @NotBlank(message = "un lastname ne doit pas être vide")
        String lastname,
        @NotBlank(message = "une adresse ne doit pas être vide")
        String address
//        @Null
//        Collection<ImpressionDTO> impressions
) {
}
