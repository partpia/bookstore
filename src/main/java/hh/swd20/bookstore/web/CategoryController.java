package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

// @CrossOrigin
@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// all categories from the database
	@GetMapping("/categorylist")
	public String getAllCategories(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "categorylist";	// categorylist.html
	}
	
	// create a new category
	@GetMapping("/newcategory")
	public String createCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";	// addcategory.html
	}
	
	// save category
	@PostMapping("/savecategory")
	public String saveCategory(@ModelAttribute Category category) {
		categoryRepository.save(category);
		return "redirect:/categorylist";
	}
}
