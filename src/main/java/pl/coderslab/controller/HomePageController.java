package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.entity.Article;

import java.util.List;

@Controller
public class HomePageController {

    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @RequestMapping("/")
    public String home(Model model){
        List<Article> articles = articleDao.findFive();
        model.addAttribute("articles", articles);
        return "homePage";
    }
}
