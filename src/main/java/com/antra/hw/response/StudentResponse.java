package com.antra.hw.response;

import com.antra.hw.domain.Student;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
@Builder
public class StudentResponse {

    private final Integer page;
    private final Integer per_page;
    private final Integer total;
    private final Integer total_pages;
    private final List<Student> data;



}
