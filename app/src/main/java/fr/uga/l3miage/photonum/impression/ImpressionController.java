package fr.uga.l3miage.photonum.impression;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping(value = "/impressions", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ImpressionDTO newImpression(@RequestBody @Valid ImpressionDTO impression) {
        var saved = impressionService.save(impressionMapper.dtoToEntity(impression));
        return impressionMapper.entityToDTO(saved);
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
}
