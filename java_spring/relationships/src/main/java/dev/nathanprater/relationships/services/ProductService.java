package dev.nathanprater.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.nathanprater.relationships.models.Category;
import dev.nathanprater.relationships.models.Product;
import dev.nathanprater.relationships.repositories.CategoryRepository;
import dev.nathanprater.relationships.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;
	
	public ProductService(ProductRepository p, CategoryRepository c) {
		this.productRepo = p;
		this.categoryRepo = c;
	}
	
	//returns all the products
	public List<Product> allProducts(){
		return productRepo.findAll();
	}
	
	//creates a Product
	public Product createProduct(Product p) {
		return productRepo.save(p);
	}
	
	//retrieves a product
	public Product findProduct(Long id) {
		Optional<Product> optionalProd = productRepo.findById(id);
		if(optionalProd.isPresent()) {
			return optionalProd.get();
		} else {
			return null;
		}
	}
	
	//retrieves all categories in product
	public List<Product> findAllProducts(Category c){
		return productRepo.findAllByCategories(c);
	}
	
	//retrieves all categories not in product
	public List<Product> findAllOtherProducts(Category c){
		return productRepo.findByCategoriesNotContains(c);
	}
	
	//adds product to products in category
	public Product addCategoryToProduct(Long prodId, Long catId) {
		Product thisProduct = this.findProduct(prodId);
		Optional<Category> optionalCat = categoryRepo.findById(catId);
		if(optionalCat.isPresent()) {
			thisProduct.getCategories().add(optionalCat.get());
			return productRepo.save(thisProduct);
		} else {
			return null;
		}
	}
}
