package com.antra.hw.controller;

import com.antra.hw.domain.Movie;
import com.antra.hw.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class MovieController {


    private RestTemplate restTemplate = new RestTemplate();

    public MovieController(){

    }

    //all pages
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> serchMovie() throws ExecutionException, InterruptedException {
        String url = "https://jsonmock.hackerrank.com/api/moviesdata/search";
        //int page = 1; //volatile

        List<Movie> allMovie = new ArrayList<>();
        ResponseEntity<MovieResponse> movieResponse = restTemplate.getForEntity(url, MovieResponse.class);
        int totalPage = movieResponse.getBody().getTotal_pages();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 8, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(50));

        for (int page = 1; page <= totalPage; page++) {
            final int pagenum = page;
            CompletableFuture<List<Movie>> future = CompletableFuture.supplyAsync(() -> {
                System.out.println("page: " + pagenum);
                        return restTemplate.getForObject(url + "?page=" + pagenum, MovieResponse.class).getData();
                    }//);
                    ,executor);
            allMovie.addAll(future.get());
        }

        executor.shutdown();
        return new ResponseEntity<>(allMovie, HttpStatus.OK);
    }

    //query parameters (page / movie name/ year)
    @GetMapping(value = "/movies", params = {"page", "movieName", "year"})
    public List<Movie> searchMovieByPage(@RequestParam int page, @RequestParam String movieName, @RequestParam Integer year){
        String url = "https://jsonmock.hackerrank.com/api/moviesdata/search?page=" + page;
        MovieResponse movieResponse= restTemplate.getForObject(url, MovieResponse.class);

        return movieResponse.getData().stream().filter( movie -> movie.getTitle().equals(movieName) && movie.getYear().equals(year)).collect(Collectors.toList());
    }

//    @GetMapping(value = "/movies/v2", params = {"page", "movieName", "year"})
//    public List<Movie> searchMovieByPageV2(@RequestParam int page, @RequestParam String movieName, @RequestParam Integer year){
//        String url = "https://jsonmock.hackerrank.com/api/moviesdata/search?page=" + page;
//        MovieResponse movieResponse =
//    }
}
