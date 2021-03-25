package com.mars.javacode.excercise.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mars.javacode.excercise.model.Person;

@Repository
public interface PersonServiceRepository extends CrudRepository<Person, Long>{
	
	Person findById(String id);
	
}
