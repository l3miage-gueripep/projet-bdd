package fr.uga.l3miage.photonum.commande;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.service.CommandeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class CommandeController {

    private final CommandeService commandeService;
    private final CommandeMapper commandeMapper;

    @Autowired
    public CommandeController(CommandeService commandeService, CommandeMapper commandeMapper) {
       this.commandeService = commandeService;
        this.commandeMapper = commandeMapper;
    }

    @PostMapping(value = "/commandes", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CommandeDTO newImpression(@RequestBody @Valid CommandeDTO impression) {
        var saved = commandeService.save(commandeMapper.dtoToEntity(impression));
        return commandeMapper.entityToDTO(saved);
    }


    @GetMapping("/commandes")
    public Collection<CommandeDTO> impressions() {
        Collection<Commande> commandes;
        commandes = commandeService.list();
        return commandes.stream()
                .map(commandeMapper::entityToDTO)
                .toList();
    }
    
    
}
