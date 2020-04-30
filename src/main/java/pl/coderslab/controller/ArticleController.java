package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("/get/{id}")
    public Article getById(@PathVariable Long id){
        return articleDao.findById(id);
    }

    @GetMapping("/all")
    public List<Article> findAllArticles(){
        return articleDao.findAll();
    }

    @PostMapping("/add/{id}")
    public Article addArticleByAuthor(@PathVariable Long id){
        Article article = new Article();
        article.setContent("Pewnego razu hopsasa.");
        article.setAuthor(authorDao.findById(id));
        Category category = categoryDao.findById(2L);
        Category category1 = categoryDao.findById(1L);
        List<Category> list = article.getCategories();
        list.add(category);
        list.add(category1);
        article.setCategories(list);
        articleDao.save(article);
        return article;
    }
}
