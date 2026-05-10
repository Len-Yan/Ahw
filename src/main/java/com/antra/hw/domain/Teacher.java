package com.antra.hw.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstname;
    @Column
    private String lastname;


    @OneToMany(mappedBy = "teacher")
    private List<StudentTeacher> studentTeachers;

}
