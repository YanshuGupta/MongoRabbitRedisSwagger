package com.example.practice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.practice.model.Message;

@Repository
public interface MessageRepository extends MongoRepository<Message, String>{

}