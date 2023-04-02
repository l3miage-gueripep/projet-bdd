package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import fr.uga.l3miage.photonum.data.repo.ClientRepository;
import fr.uga.l3miage.photonum.data.repo.ImageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class ImageServiceImpl implements ImageService{

    private final ImageRepository imageRepository;
    private final ClientRepository clientRepository;
    @Autowired
    ImageServiceImpl(ClientRepository clientRepository, ImageRepository imageRepository){
        this.imageRepository = imageRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Image save(Long clientId, Image image) throws EntityNotFoundException {
        imageRepository.save(image);
        bind(clientId, image);
        return image;
    }

    @Override
    public Image get(Long id) throws EntityNotFoundException {
        return this.imageRepository.get(id);
    }

    @Override
    public Collection<Image> list() {
        return this.imageRepository.all();
    }

    @Override
    public Image update(Image object) throws EntityNotFoundException {
        return null;
    }


    @Override
    public Collection<Image> searchByid(String query) {
        return null;
    }



    private void bind(Long clientId, Image image) throws EntityNotFoundException {
        Client client = clientRepository.get(clientId);
        client.addImage(image);
        image.setProprietaire(client);
    }
}
