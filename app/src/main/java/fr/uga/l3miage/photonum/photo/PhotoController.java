package fr.uga.l3miage.photonum.photo;

import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.image.ImageMapper;
import fr.uga.l3miage.photonum.impression.ImpressionDTO;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import fr.uga.l3miage.photonum.service.ImageService;
import fr.uga.l3miage.photonum.service.PhotoService;
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
public class PhotoController {

    private final PhotoService photoService;
    private final PhotoMapper photoMapper;

    @Autowired
    public PhotoController(PhotoService imageService, PhotoMapper imageMapper){
        this.photoService = imageService;
        this.photoMapper = imageMapper;
    }

    @PostMapping(value = "/images/{id}/photo", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public PhotoDTO newPhoto(@PathVariable("id") @NotNull Long imageId, @RequestBody @Valid PhotoDTO photo) {
        try {
            var saved = photoService.save(imageId, photoMapper.dtoToEntity(photo));
            return photoMapper.entityToDTO(saved);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, e);
        }
    }

    @GetMapping("/photos/{id}")
    public PhotoDTO photo(@PathVariable("id") @NotNull Long id) {
        try {
            return photoMapper.entityToDTO(photoService.get(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }

    @GetMapping("/photos")
    public Collection<PhotoDTO> impressions() {
        Collection<Photo> photos;
        photos = photoService.list();
        return photos.stream()
                .map(photoMapper::entityToDTO)
                .toList();
    }


}
