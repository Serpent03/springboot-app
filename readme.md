## Student Management Springboot Application

Simple student management application meant to put student data, and retrieve it on the basis of ID.

To put student data:
- curl -X POST localhost:8080/addStudent/`{name}`/`{age}`/`{aadhar}`/`{university}` -- { returns: `unique id` }

To get student data:
- curl -X POST localhost:8080/studentById/`{unique id}` 
