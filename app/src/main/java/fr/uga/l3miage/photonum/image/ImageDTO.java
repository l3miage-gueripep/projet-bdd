package fr.uga.l3miage.photonum.image;

import fr.uga.l3miage.photonum.data.domain.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;

public record ImageDTO(
        Long id,
        String emplacement,
        @Null
        Client proprietaire,
        String infos,
        Integer resolution,
        Boolean partage
) {
}