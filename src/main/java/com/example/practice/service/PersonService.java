package com.example.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.practice.dao.PersonRepository;
import com.example.practice.model.Person;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepo;
	
	public void save(Person person) {
		personRepo.save(person);
	}
	
	@Cacheable(cacheNames = "persons", key="#id")
	public Person findById(int id) {
		System.out.println("find by id called");
		Optional<Person> obj = personRepo.findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		return null;
	}
	
	public List<Person> findAll() {
		return personRepo.findAll();
	}
}
