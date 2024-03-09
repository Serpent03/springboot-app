package com.example.studentmanager.model;

import java.util.Random;

// name, age, aadhar, uni
public class StudentModel {
  private final String name;
  private final String age;
  private final String aadhar;
  private final String uni;
  private final String _id;
  private final int seedlength = 99;

  public StudentModel(String name, String age, String aadhar, String uni) {
    this.name = name;
    this.age = age;
    this.aadhar = aadhar;
    this.uni = uni;
    _id = "" + new Random().nextInt(this.seedlength); // randomize!
  }

  public StudentModel(StudentModel _student) {
    // clone the student object
    this.name = _student.getName();
    this.age = _student.getAge();
    this.aadhar = _student.getAadhar();
    this.uni = _student.getUni();
    _id = "" + new Random().nextInt(this.seedlength);
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


