package dev.nathanprater.relationships.services;

import org.springframework.stereotype.Service;

import dev.nathanprater.relationships.models.Ninja;
import dev.nathanprater.relationships.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	//creates ninja
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
}
