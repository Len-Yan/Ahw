package com.antra.hw.service;

import com.antra.hw.domain.Student;
import com.antra.hw.domain.Teacher;
import com.antra.hw.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentbyId(int id){
        return studentRepository.findById(id).orElse(new Student());
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(int id){
        studentRepository.delete(studentRepository.findById(id).orElse(new Student()));
    }

    public  List<Teacher> getAllTeacherByStudentId(int id){
        List<Teacher> teachers = studentRepository.findById(id).orElse(new Student()).getTeachers();
        return teachers;
    }
}
