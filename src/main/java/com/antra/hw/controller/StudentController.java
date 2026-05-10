package com.antra.hw.controller;


import com.antra.hw.domain.Student;
import com.antra.hw.domain.Teacher;
import com.antra.hw.response.StudentResponse;
import com.antra.hw.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //all pages
    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudent() {

        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentbyId(@PathVariable int id){

        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Student> createStudentbyId(@RequestBody Student student){
        //System.out.println(student.getFirstname());
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){

        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudentbyId(@PathVariable int id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //should in another controller, service
    @PostMapping("/teacher")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
        return new ResponseEntity<>(studentService.saveTeacher(teacher), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/teacher")
    public ResponseEntity<List<Teacher>> getStudentAllTeacher(@PathVariable int id){

        return new ResponseEntity<>(studentService.getAllTeacherByStudentId(id), HttpStatus.OK);
    }
}
