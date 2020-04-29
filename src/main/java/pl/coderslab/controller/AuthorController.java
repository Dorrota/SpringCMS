package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Author getAuthorById(@PathVariable Long id){
        return authorDao.findById(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public Author addAuthor(){
        Author author = new Author();
        author.setFirstName("Dimitrij");
        author.setLastName("Gluchovski");
        authorDao.save(author);
        return author;
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void deleteAuthor(@PathVariable Long id){
        authorDao.delete(authorDao.findById(id));
    }
}
