package fr.uga.l3miage.photonum.photo;

import fr.uga.l3miage.photonum.data.domain.Image;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Null;

public record PhotoDTO(
    Long id,
    String parametres,
    String texteDescriptif,
    @Null
    Image image
) {

}
