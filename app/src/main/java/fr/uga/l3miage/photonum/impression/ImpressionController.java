package fr.uga.l3miage.photonum.impression;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import fr.uga.l3miage.photonum.service.ImpressionService;

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

    @GetMapping("/impressions")
    public Collection<ImpressionDTO> impressions(@RequestParam(value = "q", required = false) String query) {
        Collection<Impression> impressions;
        if (query == null) {
            impressions = impressionService.list();
        } else {
            impressions = impressionService.searchByid(query);
        }
        return impressions.stream()
                .map(impressionMapper::entityToDTO)
                .toList();
    }

}
