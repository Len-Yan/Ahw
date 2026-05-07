package com.antra.hw.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Student_Teacher")
public class StudentTeacher {

    @Id
    private int studentId;
    private List<Teacher> teacher;

}
