package dev.nathanprater.languages2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.nathanprater.languages2.models.Language;
import dev.nathanprater.languages2.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	public List<Language> allLanguages() {
		return langRepo.findAll();
	}
	
	public Language createLanguage(Language lang) {
		return langRepo.save(lang);
	}
	
	public Language updateLanguage(Language lang) {
		return langRepo.save(lang);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optLang = langRepo.findById(id);
		if(optLang.isPresent()) {
			return optLang.get();
		} else {
			return null;
		}
	}
	
	public void deleteLanguage(Long id) {
		langRepo.deleteById(id);
	}
}
