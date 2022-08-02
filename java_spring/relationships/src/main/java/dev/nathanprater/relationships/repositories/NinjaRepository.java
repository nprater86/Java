package dev.nathanprater.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.nathanprater.relationships.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja,Long>{
	List<Ninja> findAll();
}
