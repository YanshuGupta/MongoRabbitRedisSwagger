package com.example.practice.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import graphql.ExecutionResult;

@RestController
public class GraphQlController {

	@Autowired
	GraphQlService graphQlService;
	
	@PostMapping
    public ResponseEntity<Object> getAllPersons(@RequestBody String query) {
        ExecutionResult execute = graphQlService.getGraphQL().execute(query);

        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
