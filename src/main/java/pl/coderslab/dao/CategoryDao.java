package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public Category findById(Long id){
        return entityManager.find(Category.class, id);
    }

    public List<Category> findAll(){
        return entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    public void save(Category category){
        entityManager.persist(category);
    }

    public void delete(Category category){
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }

    public void update(Category category){
        entityManager.merge(category);
    }
}
