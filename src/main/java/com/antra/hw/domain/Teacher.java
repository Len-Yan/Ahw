package com.antra.hw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class Teacher {

    private String name;
    private int age;
    private String gender;
    private List<Student> students;

}
