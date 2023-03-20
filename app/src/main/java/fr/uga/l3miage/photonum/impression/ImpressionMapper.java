package fr.uga.l3miage.photonum.impression;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ImpressionMapper {
    ImpressionDTO entityToDTO(Impression impression);

    Collection<ImpressionDTO> entityToDTO(Iterable<Impression> authors);

    Impression dtoToEntity(ImpressionDTO author);

    Collection<Impression> dtoToEntity(Iterable<ImpressionDTO> authors);
}