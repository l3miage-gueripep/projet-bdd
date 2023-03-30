package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.data.repo.CommandeRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {
  
    private final CommandeRepository commandeRepository;

    @Autowired
    public CommandeServiceImpl(CommandeRepository impressionRepository) {
        this.commandeRepository = impressionRepository;
    }


    @Override
    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande get(Long id) throws EntityNotFoundException {
        return commandeRepository.get(id);
    }

    @Override
    public Collection<Commande> list() {
        return commandeRepository.all();
    }

    @Override
    public Commande update(Commande object) throws EntityNotFoundException {
        return null;
    }


    //A implémenter
    @Override
    public Collection<Commande> searchByid(String query) {
        // TODO Auto-generated method stub
        return null;
    }

}
