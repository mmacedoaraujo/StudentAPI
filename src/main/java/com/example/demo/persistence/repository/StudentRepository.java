package com.example.demo.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.persistence.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

}
