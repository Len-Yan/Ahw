package com.antra.hw.service;

import com.antra.hw.domain.Student;
import com.antra.hw.domain.Teacher;
import com.antra.hw.repository.StudentRepository;
import com.antra.hw.repository.StudentTeacherRepository;
import com.antra.hw.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class StudentService {

    private StudentRepository studentRepository;
    private StudentTeacherRepository studentTeacherRepository;
    private TeacherRepository teacherRepository;

    public StudentService(StudentRepository studentRepository, StudentTeacherRepository studentTeacherRepository, TeacherRepository teacherRepository){
        this.studentRepository = studentRepository;
        this.studentTeacherRepository = studentTeacherRepository;
        this.teacherRepository = teacherRepository;
    }


    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentById(int id){
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

    public Teacher saveTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public  List<Teacher> getAllTeacherByStudentId(int id){
        List<Teacher> teachers = studentTeacherRepository.findAllTeachersByStudentId(id);
        if (teachers == null) throw new NoSuchElementException("no associated teacher");
        return teachers;
    }
}
