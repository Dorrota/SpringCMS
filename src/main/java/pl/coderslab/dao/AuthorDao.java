package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public Author findById(Long id){
        return entityManager.find(Author.class, id);
    }

    public List<Author> findAll(){
        return entityManager.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

    public void save(Author author){
        entityManager.persist(author);
    }

    public void delete(Author author){
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }

    public void  update(Author author){
        entityManager.merge(author);
    }

}
