package fr.uga.l3miage.photonum.client;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.data.domain.clients.client;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO entityToDTO(client client);

    Collection<clientDTO> entityToDTO(Iterable<client> clients);

    Client dtoToEntity(clientDTO client);

    Collection<client> dtoToEntity(Iterable<clientDTO> clients);
}