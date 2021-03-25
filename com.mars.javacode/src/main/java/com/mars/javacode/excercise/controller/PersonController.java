package com.mars.javacode.excercise.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mars.javacode.excercise.model.Person;
import com.mars.javacode.excercise.service.PersonServiceRepository;

@RestController
public class PersonController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	public PersonServiceRepository repository;
	
	@PostMapping("/addPerson")
	public void createPersonDetails(@RequestBody Person personDetails) {
		
		Person save = repository.save(personDetails);
		
		
		
		
	}
	@PutMapping("/editPerson/{personId}/firstName/{fname}/surName/{sName}")
	public void updatePersonDetails(@PathVariable Long personId ,@PathVariable String fname ,@PathVariable String sName) {
		
		Optional<Person> findById = repository.findById(personId);
		if(findById.isPresent()) {
		Person person = findById.get();
		person.setFirstName(fname);
		person.setSurName(sName);
	    repository.save(person);
		}
		
	}
	@DeleteMapping("/deletePerson/{id}")
	public void deletePerson(@PathVariable Long id) {
		
		repository.deleteById(id);
		
	}

	@GetMapping("/getPersonsList")
	public List<Person> getTotalPersons() {
		
		return	(List<Person>) repository.findAll();
		
		 
	}
	@GetMapping("/getPersonsCount")
	public Long getTotalPersonsCount() {
		
		List<Person> personDetail = (List<Person>) repository.findAll();
		
		return (long) personDetail.size();
	}

	

}
