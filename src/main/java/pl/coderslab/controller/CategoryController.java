package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Category;

import java.util.List;

@Controller
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

//    @PostMapping("/add")
//    public Category addCategory(){
//        Category category = new Category();
//        category.setName("Artykuł naukowy");
//        category.setDescription("Prezentuje wyniki oryginalnych badań o charakterze empirycznym, " +
//                "teoretycznym, technicznym lub analitycznym.");
//        categoryDao.save(category);
//        return category;
//    }
    @GetMapping("/add")
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        return "categoryForm";
    }

    @PostMapping("/add")
    public String saveCategory(@ModelAttribute Category category){
        categoryDao.save(category);
        return "redirect:/category/all"; 
    }

    @PostMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryDao.delete(categoryDao.findById(id));
    }

    @GetMapping("/all")
    public String findAllCategories(Model model){
        List<Category> categories = categoryDao.findAll();
        model.addAttribute("categories", categories);
        return "category";
    }
}
