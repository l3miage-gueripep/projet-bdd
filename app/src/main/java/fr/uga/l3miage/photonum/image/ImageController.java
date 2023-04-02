package fr.uga.l3miage.photonum.image;


import fr.uga.l3miage.photonum.client.ClientDTO;
import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import fr.uga.l3miage.photonum.data.repo.Exceptions.EchecSupressionException;
import fr.uga.l3miage.photonum.impression.ImpressionDTO;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import fr.uga.l3miage.photonum.service.ImageService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class ImageController {
    private final ImageService imageService;
    private final ImageMapper imageMapper;

    @Autowired
    public ImageController(ImageService imageService, ImageMapper imageMapper){
        this.imageService = imageService;
        this.imageMapper = imageMapper;
    }

    @PostMapping(value = "/clients/{id}/image", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ImageDTO newImpression(@PathVariable("id") @NotNull Long clientId, @RequestBody @Valid ImageDTO image) {
        try {
            var saved = imageService.save(clientId, imageMapper.dtoToEntity(image));
            return imageMapper.entityToDTO(saved);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, e);
        }
    }


    @GetMapping("/images")
    public Collection<ImageDTO> images() {
        Collection<Image> images;
        images = imageService.list();
        return images.stream()
                .map(imageMapper::entityToDTO)
                .toList();
    }


    @GetMapping("/images/{id}")
    public ImageDTO image(@PathVariable("id") @NotNull Long id) {
        try {
            return imageMapper.entityToDTO(imageService.get(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }

    @DeleteMapping("/images/{id}")
    public void deleteImage(@PathVariable("id") @NotNull Long id){
        //delete image with specified id
        try {
            imageService.delete(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        } catch (EchecSupressionException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, e);
        }
    }


    @PutMapping(value = "/images/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImageDTO updateAuthor(@RequestBody @Valid ImageDTO image, @NotNull @PathVariable("id") Long id) {
        try {
            if (image.id().equals(id)) {
                var updated = imageService.update(imageMapper.dtoToEntity(image));
                return imageMapper.entityToDTO(updated);
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "author is not found", e);
        }
    }

}
