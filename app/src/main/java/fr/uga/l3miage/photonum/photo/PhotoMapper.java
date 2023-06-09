package fr.uga.l3miage.photonum.photo;

import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.image.ImageDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface PhotoMapper {
    PhotoDTO entityToDTO(Photo photo);
    Collection<PhotoDTO> entityToDTO(Iterable<Photo> photos);
    Photo dtoToEntity(PhotoDTO photo);
    Collection<Photo> dtoToEntity(Iterable<PhotoDTO> photo);
}
