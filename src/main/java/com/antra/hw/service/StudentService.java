package com.antra.hw.service;

import com.antra.hw.domain.Student;
import com.antra.hw.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    public void saveStudent(Student student){
        //studentRepository.save(student);
    }
}
