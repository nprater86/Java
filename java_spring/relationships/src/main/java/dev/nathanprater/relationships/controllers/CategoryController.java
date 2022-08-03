package dev.nathanprater.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.nathanprater.relationships.models.Category;
import dev.nathanprater.relationships.models.Product;
import dev.nathanprater.relationships.services.CategoryService;
import dev.nathanprater.relationships.services.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	private final ProductService prodService;
	private final CategoryService catService;
	
	public CategoryController(ProductService p, CategoryService c) {
		this.prodService = p;
		this.catService = c;
	}
	
	//routes for showing category and its products
	@GetMapping("/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = catService.findCategory(id);
		List<Product> notProducts = prodService.findAllOtherProducts(category);
		model.addAttribute("category", category);
		model.addAttribute("notProducts", notProducts);
		return "/products/showCategory.jsp";
	}
	
	//routes for creating new category
	@GetMapping("/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/products/newCategory.jsp";
	}
	
	@PostMapping("")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/newCategory.jsp";
		} else {
			catService.createCategory(category);
			return "redirect:/categories/" + category.getId();
		}
	}
	
	//adding a product to a category
	@PostMapping("/addProduct")
	public String addProduct(@RequestParam(value="category_id") Long categoryId, @RequestParam(value="product_id") Long productId ) {
		catService.addProductToCategory(categoryId, productId);
		return "redirect:/categories/" + categoryId;
	}
}
