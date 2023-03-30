package fr.uga.l3miage.photonum.impression;

import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Photo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record ImpressionDTO(
    Long id,
    
    @NotBlank(message = "full name of the impresssion is mandatory")
    String nom,

    //associations
    @NotEmpty(message = "articles of the impression is mandatory")
    List<Article> articles,
    //client
    @NotEmpty(message = "client of the impression is mandatory")
    Client commanditaire,
    //photo
    @NotEmpty(message = "photos of the impression is mandatory")
    List<Photo> photos


) {
}
