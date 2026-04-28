package com.antra.hw.controller;

import com.antra.hw.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/moviesdata")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    public MovieController(){

    }

    @GetMapping("/search")
    public List<Movie> serchMovie(){
        String url = "jsonmock.hackerrank.com";
        int page;
        List<Movie> allMovie= restTemplate.getForObject(url, List.class);
        if(allMovie == null || allMovie.isEmpty()){
            System.err.println("no data found");
        }

        return allMovie;
    }

    @GetMapping("/search/{page}")
    public List<Movie> searchMovieByPage(@PathVariable int page){
        String url = "jsonmock.hackerrank.com";
        int totalPage = 0;
        restTemplate.getForObject(url, String.class);



        return new ArrayList<>();
    }


}
