package com.sham.SpringApp.controller;

import com.sham.SpringApp.Entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SpringController {
    // HTTP GET Request
    // http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }
    // HTTP GET Request
    // http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent(){
        return new Student(1,"Shambhavi","Bhat");
    }
    // HTTP GET Request
    // http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Sam","Bhat"));
        students.add(new Student(2,"Sham","Bhat"));
        students.add(new Student(3,"Ram","Bhat"));
        return students;
    }
    // HTTP GET Request
    // http://localhost:8080/student/1
    // {id} -> URI template variable
    @GetMapping("/student/{id}")
    public Student getSingleStudent(@PathVariable("id") int studentId){
        return new Student(studentId,"Saam","Bhat");
    }
    // HTTP GET Request
    // http://localhost:8080/student/1/Raam/Bhat
    // {id} -> URI template variable
    @GetMapping("/student/{id}/{first-name}/{last-name}")
    public Student getSingleStudent1(@PathVariable("id") int studentId,
                                     @PathVariable("first-name") String firstName,
                                     @PathVariable("last-name") String lastName){
        return new Student(studentId,firstName,lastName);
    }
    // HTTP GET Request
    // http://localhost:8080/student/query?id=1
    // id=1 -> Query Parameter
    @GetMapping("/student/query")
    public Student getSingleStudent2(@RequestParam int id){
        return new Student(id,"Sam","Bhat");
    }
    // HTTP GET Request
    // http://localhost:8080/student/query?id=1&firstName=Sam&lastName=Bhat
    // id=1 -> Query Parameter
    @GetMapping("/student/query1")
    public Student getSingleStudent3(@RequestParam int id,
                                     @RequestParam String firstName,
                                     @RequestParam String lastName){
        return new Student(id,firstName,lastName);
    }
    // HTTP POST Request
    // http://localhost:8080/student/add
    @PostMapping("/student/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
    // HTTP PUT Request
    // http://localhost:8080/student/update/1
    @PutMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable("id") int id,
                                 @RequestBody Student student){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
    // HTTP DELETE Request
    // http://localhost:8080/student/delete/1
    @DeleteMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
    return "Student deleted successfully!";
    }
    //---------------------------------ResponseEntity------------------------------------
    // HTTP GET Request
    // http://localhost:8080/student/re
    @GetMapping("/student/re")
    public ResponseEntity<Student> getStudent1(){
        Student student = new Student(1,"Shambhavi","Bhat");
        return new ResponseEntity<Student>(student,HttpStatus.OK);
    }
    // HTTP GET Request
    // http://localhost:8080/student/re2
    @GetMapping("/student/re2")
    public ResponseEntity<Student> getStudent2(){
        Student student = new Student(1,"Shambhavi","Bhat");
        return ResponseEntity.ok()
                .header("custom-header","Sam")
                .body(student);
    }
    // HTTP GET Request
    // http://localhost:8080/students/re
    @GetMapping("/students/re")
    public ResponseEntity<List<Student>> getStudents1(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Sam","Bhat"));
        students.add(new Student(2,"Sham","Bhat"));
        students.add(new Student(3,"Ram","Bhat"));
        return ResponseEntity.ok(students);
    }
    // HTTP POST Request
    // http://localhost:8080/student/add/re
    @PostMapping("/student/add/re")
    public ResponseEntity<Student> addStudent1(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
    // HTTP PUT Request
    // http://localhost:8080/student/update/re/1
    @PutMapping("/student/update/re/{id}")
    public ResponseEntity<Student> updateStudent1(@PathVariable("id") int id,
                                 @RequestBody Student student){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }
    // HTTP DELETE Request
    // http://localhost:8080/student/delete/re/1
    @DeleteMapping("/student/delete/re/{id}")
    public ResponseEntity<String> deleteStudent1(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}
