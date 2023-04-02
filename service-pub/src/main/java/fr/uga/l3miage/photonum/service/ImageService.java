package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import fr.uga.l3miage.photonum.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ImageService extends BaseService<Image, Long> {
    Image save(Long clientId, Image image) throws EntityNotFoundException;
    Collection<Image> searchByid(String query);
}