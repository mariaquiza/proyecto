package com.proyecto.proyecto.controller;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.proyecto.model.Student;
import com.proyecto.proyecto.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins ="http://localhost:8881")
@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentRepository studentrepository;
    /*
    public StudentController(StudentRepository studentRepository){
        this.studentrepository=studentRepository;

    }
    */

    @PostMapping("/students")
    public ResponseEntity<Student> createTutorial(@RequestBody Student student){
        try{
         Student _student = studentrepository.save(new Student(student.getName(), student.getLastname(), false));
         return new ResponseEntity<>(_student, HttpStatus.CREATED);
        } catch (Exception e) {
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllTutorials(@RequestParam(required = false) String name) {
        try {
          List<Student> tutorials = new ArrayList<Student>();
    
          if (name == null)
          studentrepository.findAll().forEach(tutorials::add);
          else
          studentrepository.findByNameContaining(name).forEach(tutorials::add);
    
          if (tutorials.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
    
          return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
      }
    

}

