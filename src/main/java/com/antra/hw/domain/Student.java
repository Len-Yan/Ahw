package com.antra.hw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class Student {

    private String name;
    private int age;
    private String gender;
    private List<Teacher> teachers;


}
