package fr.uga.l3miage.photonum.impression;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class ImpressionController {

    
    @GetMapping("/impressions")
    public Collection<ImpressionDTO> impressions(@RequestParam(value = "q", required = false) String query) {
        Collection<Impression> impressions;
        if (query == null) {
            impressions = impressionService.list();
        } else {
            impressions = impressionService.searchByName(query);
        }
        return impressions.stream()
                .map(impressionsMapper::entityToDTO)
                .toList();
    }

}
