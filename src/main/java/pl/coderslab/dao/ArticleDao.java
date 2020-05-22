package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public Article findById(Long id){
        return entityManager.find(Article.class,id);
    }

    public List<Article> findFive(){
        return entityManager.createQuery("SELECT a FROM Article a ORDER BY a.created").setMaxResults(5).getResultList();
    }
    public List<Article> findAll(){
        return entityManager.createQuery("SELECT a FROM Article a", Article.class).getResultList();
    }

    public void save(Article article){
        article.setCreated(LocalDateTime.now());
        entityManager.persist(article);
    }

    public void delete(Article article){
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public void update(Article article){
        article.setUpdated(LocalDateTime.now());
        entityManager.merge(article);
    }
}
