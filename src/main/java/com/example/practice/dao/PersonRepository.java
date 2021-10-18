package com.example.practice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.practice.model.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, Integer>{

}