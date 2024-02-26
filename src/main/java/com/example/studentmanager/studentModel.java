package com.example.studentmanager;
import java.util.ArrayList;
import java.util.Random;

// name, age, aadhar, uni
public class studentModel {
  private String name;
  private int age;
  private String aadhar;
  private String uni;
  private int _id;

  public studentModel(String name, int age, String aadhar, String uni) {
    this.name = name;
    this.age = age;
    this.aadhar = aadhar;
    this.uni = uni;
    _id = new Random().nextInt(9999999); // randomize!
  }

  // public void clone(studentModel s) {
  //   return studentModel(s.name, s.age, s.aadhar, s.uni);
  // }

  public int getStudentId() {
    return this._id;
  }

  public String getName() {
    return this.name;
  }

  public String getUni() {
    return this.uni;
  }
}

class studentStorage {
  ArrayList<studentModel> sm;
  public studentStorage() {
    this.sm = new ArrayList<>();
  }
  private void insertNewStudent(studentModel student) {
    this.sm.add(student);
  }
  public int addStudent(String name, int age, String aadhar, String uni) {
    studentModel s = new studentModel(name, age, aadhar, uni);
    this.insertNewStudent(s);
    return s.getStudentId(); // @todo verify information integrity checks
  }
  public studentModel returnStudentById(int id) {
    if (this.sm.size() == 0) {
      return null;
    }
    for (studentModel s : this.sm) {
      if (s.getStudentId() == id) {
        return s;
      }
    }
    return null; // the student has not been found.
  }
  public studentModel returnStudentByUni(final String uni) {
    if (this.sm.size() == 0) {
      return null;
    }
    studentModel stu;
    for (int i = 0; i < this.sm.size(); i++) {
      stu = this.sm.get(i);
      if (stu.getUni() == uni) {
        return stu;
      }
    }
    return null; 
    // the university has not been found
    // @todo possible improvements: case insensitivity 
  }
}
