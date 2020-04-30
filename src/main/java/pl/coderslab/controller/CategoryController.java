package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Category;

import java.util.List;

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
        category.setName("Artykuł naukowy");
        category.setDescription("Prezentuje wyniki oryginalnych badań o charakterze empirycznym, " +
                "teoretycznym, technicznym lub analitycznym.");
        categoryDao.save(category);
        return category;
    }

    @PostMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryDao.delete(categoryDao.findById(id));
    }

    @GetMapping("/all")
    public List<Category> findAllCategories(){
        return categoryDao.findAll();
    }
}
