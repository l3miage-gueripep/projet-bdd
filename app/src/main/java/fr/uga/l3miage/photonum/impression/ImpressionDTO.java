package fr.uga.l3miage.photonum.impression;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Photo;
import jakarta.validation.constraints.NotBlank;


public record ImpressionDTO(
    Long id,
    
    @NotBlank(message = "full name of the impresssion is mandatory")
    String nom
) {
}
