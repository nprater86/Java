package dev.nathanprater.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.nathanprater.relationships.models.License;
import dev.nathanprater.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepo;
	
	public LicenseService(LicenseRepository licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
	
	//return all licenses
	public List<License> allLicenses(){
		return licenseRepo.findAll();
	}
	
	//create a person
	public License createLicense(License l) {
		int largestNum = generateLicenseNumber();
		String number = String.format("%08d", largestNum);
		l.setNumber(number);
		return licenseRepo.save(l);
	}
	
	public Integer generateLicenseNumber() {
		License l = licenseRepo.findTopByOrderByNumberDesc();
		if(l == null)
			return 1;
		Integer largestNumber = Integer.parseInt(l.getNumber());
		largestNumber++;
		return (largestNumber);
	}
}
