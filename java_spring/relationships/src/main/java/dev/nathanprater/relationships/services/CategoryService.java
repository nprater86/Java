package dev.nathanprater.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.nathanprater.relationships.models.Category;
import dev.nathanprater.relationships.models.Product;
import dev.nathanprater.relationships.repositories.CategoryRepository;
import dev.nathanprater.relationships.repositories.ProductRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepo;
	private final ProductRepository prodRepo;
	
	public CategoryService(CategoryRepository c, ProductRepository p) {
		this.categoryRepo = c;
		this.prodRepo = p;
	}
	
	//returns all the categories
	public List<Category> allCategories(){
		return categoryRepo.findAll();
	}
	
	//creates a Product
	public Category createCategory(Category c) {
		return categoryRepo.save(c);
	}
	
	//retrieves a product
	public Category findCategory(Long id) {
		Optional<Category> optionalCat = categoryRepo.findById(id);
		if(optionalCat.isPresent()) {
			return optionalCat.get();
		} else {
			return null;
		}
	}
	
	//retrieves all categories in product
	public List<Category> findAllCategories(Product p){
		return categoryRepo.findAllByProducts(p);
	}
	
	//retrieves all categories not in product
	public List<Category> findAllOtherCategories(Product p){
		return categoryRepo.findByProductsNotContains(p);
	}
	
	//adds product to products in category
	public Category addProductToCategory(Long catId, Long prodId) {
		Category thisCategory = this.findCategory(catId);
		Optional<Product> optionalProd = prodRepo.findById(prodId);
		if(optionalProd.isPresent()) {
			thisCategory.getProducts().add(optionalProd.get());
			return categoryRepo.save(thisCategory);
		} else {
			return null;
		}
	}
}
