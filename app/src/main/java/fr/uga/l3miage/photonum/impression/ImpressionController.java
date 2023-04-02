package fr.uga.l3miage.photonum.impression;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import fr.uga.l3miage.photonum.service.ImpressionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class ImpressionController {

    private final ImpressionService impressionService;
    private final ImpressionMapper impressionMapper;

    @Autowired
    public ImpressionController(ImpressionService impressionService, ImpressionMapper impressionMapper) {
       this.impressionService = impressionService;
        this.impressionMapper = impressionMapper;
    }

    @PostMapping(value = "/clients/{id}/impression", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ImpressionDTO newImpression(@PathVariable("id") @NotNull Long clientId, @RequestBody @Valid ImpressionDTO impression) {
        try {
            var saved = impressionService.save(clientId, impressionMapper.dtoToEntity(impression));
            return impressionMapper.entityToDTO(saved);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, e);
        }
    }


    @GetMapping("/impressions")
    public Collection<ImpressionDTO> impressions() {
        Collection<Impression> impressions;
        impressions = impressionService.list();
        return impressions.stream()
                .map(impressionMapper::entityToDTO)
                .toList();
    }

    
    @GetMapping("/impressions/{id}")
    public ImpressionDTO impression(@PathVariable("id") @NotNull Long id) {
        try {
            return impressionMapper.entityToDTO(impressionService.get(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }

    @PutMapping(value = "/impressions/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ImpressionDTO updateAuthor(@RequestBody @Valid ImpressionDTO impression, @NotNull @PathVariable("id") Long id) {
        try {
            if (impression.id().equals(id)) {
                impressionService.get(id);
                var updated = impressionService.update(impressionMapper.dtoToEntity(impression));
                return impressionMapper.entityToDTO(updated);
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "author is not found", e);
        }
    }
/* 
    @DeleteMapping("/impressions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImpression(@PathVariable("id") @NotNull Long id) {
        try {
            impressionService.delete(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
        try {
            impressionService.delete(id);
        } catch (Exception ep) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, ep);
        }
    }
    */
}
