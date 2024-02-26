package com.example.studentmanager;

import com.example.studentmanager.*;
// import com.example.studentmanager.studentStorage;

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

  @GetMapping("/")
  public String home() {
    String str = "hi brodie";
    
    return str;
  }

  @PostMapping("/studentById/{id}") // add payload
  public String getStudentById(@PathVariable String id) {
    StringBuilder str = new StringBuilder();
    studentModel sm = ss.returnStudentById(id);
    if (sm == null) {
      return "No such student!" + ss.sm.size();
    }
    str.append(sm.getName() + " " + sm.getUni());
    // @todo call the return students method
    return str.toString();
  }

  @GetMapping("/studentByUni/{uni}")
  public String getStudentByUni(@PathVariable String uni) {
    studentModel sm = ss.returnStudentById(uni);
    if (sm == null) {
      return "No such student!";
    }
    return sm.getName();
  }
 
  @PostMapping("/addStudent/{name}/{age}/{aadhar}/{uni}")
  public String addStudent(@PathVariable String name, String age, String aadhar, String uni) {
    return "" + ss.addStudent(name, age, aadhar, uni);
  }
}
