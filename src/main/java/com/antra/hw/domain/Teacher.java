package com.antra.hw.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;

    @Column
    private String firstname;
    @Column
    private String lastname;


    @ManyToOne
    @JoinColumn(name = "foreign key")
    private Student student;

}
