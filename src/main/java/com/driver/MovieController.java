package com.driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class MovieController {
    @Autowired
     MovieService service;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String name=movie.getName();
        service.addMovieInService(name,movie);
        return new ResponseEntity<>("New movie added successfully",HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String name=director.getName();
        service.addDirectorInService(name,director);
        return new ResponseEntity<>("New director added successfully",HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie,@RequestParam("director") String director){

        service.addinPair(director,movie);
        return new ResponseEntity<>("New movie-director pair added successfully",HttpStatus.CREATED);

    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie>  getMovieByName(@PathVariable String name){
        Movie movie = service.getMovieByNameformService(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public  ResponseEntity<Director>  getDirectorByName(@PathVariable String name){
        Director director = service.getDirectorByNameformService(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }


    @GetMapping("/get-movies-by-director-name/{name}")
    public  ResponseEntity<List<String>>  getMoviesByDirectorName(@PathVariable String name){
        List<String> list= service.getListFromService(name);
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }
    @GetMapping("/get-all-movies")
    public  ResponseEntity<List<String>> findAllMovies(){
        List<String> list= service.getallMoviesformservice();
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        service.deleteDirectorByNameformservice(director);
        return new ResponseEntity<>(director+"remove successfully ",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        service.deleteAllDirectorsfromsevice();
        return new ResponseEntity<>(" remove successfully",HttpStatus.CREATED);
    }

}
