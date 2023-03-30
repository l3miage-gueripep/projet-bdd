package fr.uga.l3miage.photonum.client;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.uga.l3miage.photonum.data.domain.clients.client;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import fr.uga.l3miage.photonum.service.clientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class ClientController {

    private final clientService clientService;
    private final clientMapper clientMapper;

    @Autowired
    public clientController(clientService clientService, clientMapper clientMapper) {
       this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @PostMapping(value = "/clients", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public clientDTO newclient(@RequestBody @Valid clientDTO client) {
        var saved = clientService.save(clientMapper.dtoToEntity(client));
        return clientMapper.entityToDTO(saved);
    }


    @GetMapping("/clients")
    public Collection<clientDTO> clients() {
        Collection<client> clients;
        clients = clientService.list();
        return clients.stream()
                .map(clientMapper::entityToDTO)
                .toList();
    }

    
    @GetMapping("/clients/{id}")
    public clientDTO client(@PathVariable("id") @NotNull Long id) {
        try {
            return clientMapper.entityToDTO(clientService.get(id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
        }
    }
}
