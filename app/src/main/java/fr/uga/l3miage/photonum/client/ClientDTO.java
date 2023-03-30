package fr.uga.l3miage.photonum.client;

// import java.util.List;

// import fr.uga.l3miage.photonum.data.domain.Article;
// import fr.uga.l3miage.photonum.data.domain.Client;
// import fr.uga.l3miage.photonum.data.domain.Photo;
import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

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
