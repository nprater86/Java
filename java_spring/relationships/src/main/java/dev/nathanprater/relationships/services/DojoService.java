package dev.nathanprater.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.nathanprater.relationships.models.Dojo;
import dev.nathanprater.relationships.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	//returns all Dojos
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	//Create Dojo
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	//Retrieve a dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
}
