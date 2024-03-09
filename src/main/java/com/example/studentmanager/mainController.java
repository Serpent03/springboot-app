package com.example.studentmanager;

import com.example.studentmanager.controllers.*;
import com.example.studentmanager.model.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

// add students
// store students
// get student by id
// get students by uni

// @todo what is necessary in production level code? 
// -- unit testing
// -- factory methods?
// -- SOLID principle integration?

@SpringBootApplication
@RestController
public class mainController {
  static StudentStorage ss;

	public static void main(String[] args) {
		SpringApplication.run(mainController.class, args);
    ss = new StudentStorage();
	}

  @GetMapping("/studentById/{id}") // add payload
  public String getStudentById(@PathVariable String id) {
    StudentModel sm = ss.returnStudentById(id);
    if (sm == null) {
      return "No such student!\n";
    }
    return "Name: " + sm.getName() + "\nAge: " + sm.getAge() + "\nAadhar: " + sm.getAadhar() + "\nUniversity: " + sm.getUni() + "\n";
  }

  @GetMapping("/studentByUni/{uni}")
  public String getStudentByUni(@PathVariable String uni) {

    StringBuilder str = new StringBuilder();
    ArrayList<StudentModel> sm = ss.returnStudentByUni(uni);

    if (sm == null) {
      return "No such student!\n";
    }
    for (StudentModel s : sm) {
      str.append("Name: ").append(s.getName()).append("\nAge: ").append(s.getAge()).append("\nAadhar: ").append(s.getAadhar()).append("\nUniversity: ").append(s.getUni()).append("\n");
    }
    return str.toString() + "\n";
  }
 
  @PostMapping("/addStudent")
  public String addStudent(@RequestBody StudentModel Student) {
    return "uid: " + ss.addStudent(Student) + "\n";
  }
}
