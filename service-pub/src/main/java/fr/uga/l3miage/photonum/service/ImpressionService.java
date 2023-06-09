package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;
import fr.uga.l3miage.photonum.service.base.BaseService;
import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface ImpressionService extends BaseService<Impression, Long> {

    Impression save(Long clientId, Impression impression) throws EntityNotFoundException;

    Collection<Impression> searchByid(String query);

}