package fr.uga.l3miage.photonum.data.repo;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class DeleteRows extends Base{
    @Autowired
    EntityManager entityManager;

    @Test
    void deleteAllRows(){
        
        // Obtain a list of all entity classes
        List<Class<?>> entityClasses = this.entityManager.getMetamodel().getEntities().stream()
        .map(entity -> entity.getJavaType())
        .collect(Collectors.toList());

        // Delete all rows from each table
        for (Class<?> entityClass : entityClasses) {
            String entityName = entityClass.getSimpleName();
            Query query = entityManager.createQuery("DELETE FROM " + entityName);
            query.executeUpdate();
        }


    }

}
