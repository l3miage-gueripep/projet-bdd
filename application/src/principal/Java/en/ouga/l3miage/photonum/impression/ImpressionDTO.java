package fr.uga.l3miage.photonum.impression;

import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Photo;
import jakarta.validation.constraints.NotBlank;

public record ImpressionDTO(
     Long id,

    @NotBlank(message = "full name of the author is mandatory")
    String nom,
    List<Article> articles,
    Client commanditaire,

    Photo photo
) {
}
