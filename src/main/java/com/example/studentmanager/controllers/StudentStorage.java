package com.example.studentmanager.controllers;

import java.util.ArrayList;
import com.example.studentmanager.model.StudentModel;

public class StudentStorage {
  ArrayList<StudentModel> sm;
  public StudentStorage() {
    this.sm = new ArrayList<>();
  }
  private void insertNewStudent(StudentModel student) {
    this.sm.add(student);
  }
  public String addStudent(StudentModel _student) {
    StudentModel s = new StudentModel(_student);
    this.insertNewStudent(s);
    return s.getStudentId(); // @todo verify information integrity checks
  }
  public StudentModel returnStudentById(final String id) {
    if (this.sm.isEmpty()) {
      return null;
    }
    for (StudentModel s : this.sm) {
      System.out.println(s.getStudentId() + " " + s.getName());
      if (s.getStudentId().equals(id)) {
        return s;
      }
    }
    return null; // the student has not been found.
  }
  public ArrayList<StudentModel> returnStudentByUni(final String uni) {
    if (this.sm.isEmpty()) {
      return null;
    }
    ArrayList<StudentModel> matchingUnis = new ArrayList<>();
    StudentModel stu;
    for (int i = 0; i < this.sm.size(); i++) {
      stu = this.sm.get(i);
      if (stu.getUni().equals(uni)) {
        matchingUnis.add(stu);
      }
    }
    return matchingUnis; 
    // the university has not been found
    // @todo possible improvements: case insensitivity 
  }
}
