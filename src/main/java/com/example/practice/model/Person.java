package com.example.practice.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Person implements Serializable {
	private String name;
	@Id
	private int id;
	
	public Person(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
