package com.example.practice.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.practice.dao.PersonRepository;
import com.example.practice.model.Person;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllPersonDataFetcher implements DataFetcher<List<Person>> {

	@Autowired
	PersonRepository personRepo;
	
	@Override
    public List<Person> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return personRepo.findAll();
    }
}

