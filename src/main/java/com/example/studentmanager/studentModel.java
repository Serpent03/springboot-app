package com.example.studentmanager;
import java.util.ArrayList;
import java.util.Random;

// name, age, aadhar, uni
public class studentModel {
  private final String name;
  private final String age;
  private final String aadhar;
  private final String uni;
  private final String _id;

  public studentModel(String name, String age, String aadhar, String uni) {
    this.name = name;
    this.age = age;
    this.aadhar = aadhar;
    this.uni = uni;
    _id = "" + new Random().nextInt(99); // randomize!
  }

  public String getStudentId() {
    return this._id;
  }

  public String getName() {
    return this.name;
  }

  public String getUni() {
    return this.uni;
  }

  public String getAge() {
    return this.age;
  }

  public String getAadhar() {
    return this.aadhar;
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
  public String addStudent(String name, String age, String aadhar, String uni) {
    studentModel s = new studentModel(name, age, aadhar, uni);
    this.insertNewStudent(s);
    return s.getStudentId(); // @todo verify information integrity checks
  }
  public studentModel returnStudentById(final String id) {
    if (this.sm.isEmpty()) {
      return null;
    }
    for (studentModel s : this.sm) {
      System.out.println(s.getStudentId() + " " + s.getName());
      if (s.getStudentId().equals(id)) {
        return s;
      }
    }
    return null; // the student has not been found.
  }
  public ArrayList<studentModel> returnStudentByUni(final String uni) {
    if (this.sm.isEmpty()) {
      return null;
    }
    ArrayList<studentModel> matchingUnis = new ArrayList<>();
    studentModel stu;
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
