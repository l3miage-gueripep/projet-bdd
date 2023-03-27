package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Impressions.Page;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PageRepository  implements CRUDRepository<Long, Page>{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page save(Page page) {
        entityManager.persist(page);
        return page;
    }

    @Override
    public Page get(Long id) {
        return entityManager.find(Page.class, id);
    }


    @Override
    public void delete(Page page) {
        entityManager.remove(page);
    }


    @Override
    public List<Page> all() {
        return null;
    }
}
