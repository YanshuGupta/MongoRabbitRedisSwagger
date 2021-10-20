package com.example.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.practice.dao.PersonRepository;
import com.example.practice.exception.CustomException;
import com.example.practice.model.Person;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepo;
	
	@CachePut(cacheNames = "persons", key = "#person.getId()")
	public Person save(Person person) {
		return personRepo.save(person);
	}
	
	@Cacheable(cacheNames = "persons", key="#id")
	public Person findById(int id) throws CustomException {
		System.out.println("find by id called");
		Optional<Person> obj = personRepo.findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		throw new CustomException("Person Not Found");
	}
	
	@Cacheable(cacheNames = "persons")
	public List<Person> findAll() {
		return personRepo.findAll();
	}
	
	@CacheEvict(cacheNames = "persons", key="#id")
	public void deleteById(int id) {
		personRepo.deleteById(id);
	}
	
}
