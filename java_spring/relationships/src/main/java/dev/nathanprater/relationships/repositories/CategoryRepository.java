package dev.nathanprater.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.nathanprater.relationships.models.Category;
import dev.nathanprater.relationships.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long>{
	List<Category> findAll();
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);
}
