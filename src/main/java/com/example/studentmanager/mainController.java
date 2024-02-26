package com.example.studentmanager;

import com.example.studentmanager.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

// add students
// store students
// get student by id
// get student by uni

@SpringBootApplication
@RestController
public class mainController {
  static studentStorage ss;

	public static void main(String[] args) {
		SpringApplication.run(mainController.class, args);
    ss = new studentStorage();
	}

  @PostMapping("/studentById/{id}") // add payload
  public String getStudentById(@PathVariable String id) {
    studentModel sm = ss.returnStudentById(id);
    if (sm == null) {
      return "No such student!";
    }
    return "Name: " + sm.getName() + "\nAge: " + sm.getAge() + "\nAadhar: " + sm.getAadhar() + "\nUniversity: " + sm.getUni() + "\n";
  }

  @PostMapping("/studentByUni/{uni}")
  public String getStudentByUni(@PathVariable String uni) {

    StringBuilder str = new StringBuilder();
    ArrayList<studentModel> sm = ss.returnStudentByUni(uni);

    if (sm == null) {
      return "No such student!";
    }
    for (studentModel s : sm) {
      str.append("Name: ").append(s.getName()).append("\nAge: ").append(s.getAge()).append("\nAadhar: ").append(s.getAadhar()).append("\nUniversity: ").append(s.getUni()).append("\n");
    }
    return str.toString() + "\n";
  }
 
  @PostMapping("/addStudent/{name}/{age}/{aadhar}/{uni}")
  public String addStudent(@PathVariable String name, @PathVariable String age, @PathVariable String aadhar, @PathVariable String uni) {
    return "uid: " + ss.addStudent(name, age, aadhar, uni) + "\n";
  }
}
