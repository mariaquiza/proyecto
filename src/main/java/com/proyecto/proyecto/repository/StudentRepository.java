package com.proyecto.proyecto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

import com.proyecto.proyecto.model.Student;

public interface StudentRepository extends MongoRepository<Student, String>{
    List<Student> findBypublished(boolean publish);
    List<Student> findByNameContaining(String name);
}
