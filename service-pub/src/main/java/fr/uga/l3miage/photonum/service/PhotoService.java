package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface PhotoService extends BaseService<Photo, Long> {
    Photo save(Long imageId, Photo photo) throws EntityNotFoundException;
    Collection<Photo> searchByid(String query);
}