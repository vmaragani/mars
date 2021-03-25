package com.mars.javacode.excercise.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mars.javacode.excercise.exceptions.PersonNotFoundException;
import com.mars.javacode.excercise.model.Person;
import com.mars.javacode.excercise.service.PersonServiceRepository;

@RestController
public class PersonController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public PersonServiceRepository repository;

	@PostMapping("/addPerson")
	public ResponseEntity<Object> createPersonDetails(@RequestBody Person personDetails) {
		logger.info("create person method is executing");
		Person person = repository.save(personDetails);
		return new ResponseEntity<Object>("Person is created successfully with id = " + person.getId(),
				HttpStatus.CREATED);
	}

	@PutMapping("/editPerson/{personId}/firstName/{fname}/surName/{sName}")
	public ResponseEntity<Object> updatePersonDetails(@PathVariable Long personId, @PathVariable String fname,
			@PathVariable String sName) {
		logger.info("update person method is executing");
		Optional<Person> findById = repository.findById(personId);
		if (findById.isPresent()) {
			Person person = findById.get();
			person.setFirstName(fname);
			person.setSurName(sName);
			repository.save(person);
			return new ResponseEntity<Object>("Person is updated successfully with id = " + personId, HttpStatus.OK);
		} else {
			throw new PersonNotFoundException("Person not found");
		}

	}

	@DeleteMapping("/deletePerson/{id}")
	public ResponseEntity<Object> deletePerson(@PathVariable Long id) {
		logger.info("delete person method is executing");
		Optional<Person> findById = repository.findById(id);
		if (findById.isPresent()) {
			repository.deleteById(id);
			return new ResponseEntity<Object>("Person is deleted successfully with id = " + id, HttpStatus.OK);
		} else {
			throw new PersonNotFoundException("Person not found");
		}

	}

	@GetMapping("/getPersonsList")
	public ResponseEntity<Object> getTotalPersons() {
		logger.info("getPersonsList method is executing");
		List<Person> personList = (List<Person>) repository.findAll();
		return new ResponseEntity<Object>(personList, HttpStatus.OK);

	}

	@GetMapping("/getPersonsCount")
	public ResponseEntity<Object> getTotalPersonsCount() {
		logger.info("getPersonsCount method is executing");
		List<Person> personDetail = (List<Person>) repository.findAll();

		return new ResponseEntity<Object>(personDetail, HttpStatus.OK);
	}

}
