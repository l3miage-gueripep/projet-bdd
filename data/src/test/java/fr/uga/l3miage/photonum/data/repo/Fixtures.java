package fr.uga.l3miage.photonum.data.repo;

import com.github.javafaker.Faker;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.data.domain.Impressions.Impression;

import java.util.Random;

public class Fixtures {

    private static final Faker FAKER = Faker.instance(new Random(42));

    public static Impression newImpression() {
        Impression impression = new Impression();
        
        return impression;
    }

    public static Image newImage() {
        Image image = new Image();
        
        return image;
    }

    public static Photo newPhoto(){
        Photo photo = new Photo();
        return photo;
    }

    public static Adresse newAdresse(){
        Adresse adresse = new Adresse();
        return adresse;
    }


}
