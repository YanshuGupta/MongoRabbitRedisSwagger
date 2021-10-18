package com.example.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.exception.CustomException;
import com.example.practice.model.Person;
import com.example.practice.service.PersonService;

@RestController
public class HomeController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable final int id) throws CustomException {
		Assert.notNull(id, "Id can't be null");
		return personService.findById(id);
	}
	
	@PostMapping("/person")
	public Person savePerson(@RequestBody final Person person) {
		Assert.notNull(person, "Person Object can't be null");
		return personService.save(person);
	}
	
	@GetMapping("/persons")
	public List<Person> getAllPerson() {
		return personService.findAll();
	}
	
	@DeleteMapping("/person/{id}")
	public boolean deletePerson(@PathVariable final int id) {
		Assert.notNull(id, "Id can't be null");
		personService.deleteById(id);
		return true;
	}
}
