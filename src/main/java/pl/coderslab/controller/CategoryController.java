package pl.coderslab.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Category;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @RequestMapping("/get/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryDao.findById(id);
    }

    @PostMapping("/add")
    public Category addCategory(){
        Category category = new Category();
        category.setName("Reportaż");
        category.setDescription("Opis zdarzeń lub faktów oparty na autentycznym materiale");
        categoryDao.save(category);
        return category;
    }

    @PostMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryDao.delete(categoryDao.findById(id));
    }
}
