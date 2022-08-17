package dev.nathanprater.auth.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.nathanprater.auth.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findById();
	List<User> findAll();
	User findByUsername(String username);
}