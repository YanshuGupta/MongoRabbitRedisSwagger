package com.example.practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.model.Person;
import com.example.practice.service.PersonService;

@RestController
public class HomeController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/index/{id}")
	public Person getAPITesting(@PathVariable int id) {
		return personService.findById(id);
	}
	
	@PostMapping("/home")
	public List<Person> postAPITesting(@RequestBody String name) {
		personService.save(new Person(name, Person.count++));
		return personService.findAll();
	}
}
