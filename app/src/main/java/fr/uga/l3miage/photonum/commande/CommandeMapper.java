package fr.uga.l3miage.photonum.commande;

import java.util.Collection;

import fr.uga.l3miage.photonum.data.domain.Commande;

public interface CommandeMapper {

    CommandeDTO entityToDTO(Commande commande);

    Collection<CommandeDTO> entityToDTO(Iterable<Commande> commandes);

    Commande dtoToEntity(CommandeDTO impression);

    Collection<Commande> dtoToEntity(Iterable<CommandeDTO> impressions);
}

