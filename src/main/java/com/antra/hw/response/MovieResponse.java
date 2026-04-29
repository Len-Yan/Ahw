package com.antra.hw.response;

import com.antra.hw.domain.Movie;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
@Builder
public class MovieResponse {

    private final Integer page;
    private final Integer per_page;
    private final Integer total;
    private final Integer total_pages;
    private final List<Movie> data;


//    public MovieResponse(Integer page, Integer perPage, Integer total, Integer totalPages, List<Movie> data) {
//        this.page = page;
//        per_page = perPage;
//        this.total = total;
//        total_pages = totalPages;
//        this.data = data;
//    }
}
