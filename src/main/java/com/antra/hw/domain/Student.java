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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column
    private String firstname;
    @Column
    private String lastname;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Teacher> teachers = new ArrayList<>();


}
