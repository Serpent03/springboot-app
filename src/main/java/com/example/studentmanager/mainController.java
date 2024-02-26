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

  @GetMapping("/studentById") // add payload
  public String getStudentById() {
    StringBuilder str = new StringBuilder();
    studentModel sm = ss.returnStudentById(0);
    if (sm == null) {
      return "No such student!";
    }
    str.append(sm.getName() + " " + sm.getUni());
    // @todo call the return students method
    return str.toString();
  }
 
  @PostMapping("/addStudent/{name}/{age}/{aadhar}/{uni}")
  public String addStudent(@PathVariable String name, int age, String aadhar, String uni) {
    return "" + ss.addStudent(name, age, aadhar, uni);
  }
}
