package com.antra.hw.repository;

import com.antra.hw.domain.StudentTeacher;
import com.antra.hw.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentTeacherRepository extends JpaRepository<StudentTeacher, Integer> {

    public List<Teacher> findAllTeachersByStudentId(int id);
}
