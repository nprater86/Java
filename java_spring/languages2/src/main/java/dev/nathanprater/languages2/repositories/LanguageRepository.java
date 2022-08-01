package dev.nathanprater.languages2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.nathanprater.languages2.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {
	List<Language> findAll();
}
