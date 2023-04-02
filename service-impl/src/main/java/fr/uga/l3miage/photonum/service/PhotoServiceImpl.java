package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.data.repo.ClientRepository;
import fr.uga.l3miage.photonum.data.repo.ImageRepository;
import fr.uga.l3miage.photonum.data.repo.ImpressionRepository;
import fr.uga.l3miage.photonum.data.repo.PhotoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class PhotoServiceImpl implements PhotoService{


    private final PhotoRepository photoRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public PhotoServiceImpl(ImageRepository imageRepository, PhotoRepository photoRepository) {
        this.imageRepository = imageRepository;
        this.photoRepository = photoRepository;
    }
    @Override
    public Photo save(Long imageId, Photo photo) throws EntityNotFoundException {
        photoRepository.save(photo);
        bind(imageId, photo);
        return photo;
    }

    @Override
    public Collection<Photo> searchByid(String query) {
        return null;
    }

    @Override
    public Photo get(Long id) throws EntityNotFoundException {
        return photoRepository.get(id);
    }

    @Override
    public Collection<Photo> list() {
        return photoRepository.all();
    }

    @Override
    public Photo update(Photo object) throws EntityNotFoundException {
        return null;
    }

    private void bind(Long imageId, Photo photo) throws EntityNotFoundException {
        Image image = imageRepository.get(imageId);
        image.addPhoto(photo);
        photo.setImage(image);
    }
}
