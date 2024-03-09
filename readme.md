## Student Management Springboot Application

Simple student management application meant to put student data, and retrieve it on the basis of ID.

To put student data:
- curl -i -H "Accept: application/json" -H "Content-Type:application/json" -X POST --data '{"name": "", "age": "", "aadhar": "password", "uni": ""}' "localhost:8080/addStudent", where the JSON data is encapsulated inside the `--data` argument.


To get student data:
- curl -X POST localhost:8080/studentById/`{unique id}` 
