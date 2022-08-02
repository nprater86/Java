package dev.nathanprater.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.nathanprater.relationships.models.Person;
import dev.nathanprater.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepo;
	
	public PersonService(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	//return all persons
	public List<Person> allPersons(){
		return personRepo.findAll();
	}
	
	//create a person
	public Person createPerson(Person p) {
		return personRepo.save(p);
	}
	
	//retrieves a person
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepo.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
}
