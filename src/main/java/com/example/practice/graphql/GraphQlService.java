package com.example.practice.graphql;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.example.practice.dao.PersonRepository;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQlService {
	@Autowired
	PersonRepository personRepo;

	private GraphQL graphQL;
	
	@Autowired
	private AllPersonDataFetcher allpersonsDataFetcher;
	
	@Autowired
	private PersonDataFetcher personDataFetcher;
	
	@Value("classpath:person.graphql")
	Resource resource;

	@PostConstruct
	private void loadSchema() throws IOException {

		// get the schema
		File schemaFile = resource.getFile();
		// parse schema
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring().type("Query", typeWiring -> typeWiring
				.dataFetcher("findAll", allpersonsDataFetcher).dataFetcher("findById", personDataFetcher)).build();
	}
	
	public GraphQL getGraphQL() {
        return graphQL;
    }
}
