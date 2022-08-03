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
@RequestMapping("/products")
public class ProductController {
	private final ProductService prodService;
	private final CategoryService catService;
	
	public ProductController(ProductService p, CategoryService c) {
		this.prodService = p;
		this.catService = c;
	}
	
	//routes for showing product and its categories
	@GetMapping("/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = prodService.findProduct(id);
		List<Category> notCategories = catService.findAllOtherCategories(product);
		model.addAttribute("product", product);
		model.addAttribute("notCategories", notCategories);
		return "/products/showProduct.jsp";
	}
	
	//routes for creating new product
	@GetMapping("/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/products/newProduct.jsp";
	}
	
	@PostMapping("")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/newProduct.jsp";
		} else {
			prodService.createProduct(product);
			return "redirect:/products/" + product.getId();
		}
	}
	
	//adding a category to a product
	@PostMapping("/addCategory")
	public String addCategory(@RequestParam(value="category_id") Long categoryId, @RequestParam(value="product_id") Long productId ) {
		prodService.addCategoryToProduct(productId, categoryId);
		return "redirect:/categories/" + productId;
	}
}
