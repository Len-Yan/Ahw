package com.antra.hw.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstname;
    @Column
    private String lastname;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<StudentTeacher> studentTeachers = new ArrayList<>();


}
