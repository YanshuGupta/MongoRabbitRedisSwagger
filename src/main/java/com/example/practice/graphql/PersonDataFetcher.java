package com.example.practice.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.practice.dao.PersonRepository;
import com.example.practice.model.Person;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class PersonDataFetcher implements DataFetcher<Person> {

	@Autowired
	PersonRepository personRepo;

	@Override
	public Person get(DataFetchingEnvironment dataFetchingEnvironment) {

		int id = dataFetchingEnvironment.getArgument("id");

		return personRepo.findById(id).get();
	}
}
