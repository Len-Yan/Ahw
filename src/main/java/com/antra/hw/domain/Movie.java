package com.antra.hw.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    private String title;
    private String year;
    private String imdbID;

    public Movie(String title, String year, String imdbID) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
    }
}
