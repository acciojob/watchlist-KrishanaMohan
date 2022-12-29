package com.driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

public class MovieController {
    @Autowired
     MovieService service;
    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        String name=movie.getName();
        service.addMovieInService(name,movie);
        return new ResponseEntity<>("success message wrapped in a ResponseEntity object",HttpStatus.OK);
    }

    @PostMapping("/add_director")
    public ResponseEntity<String> addMovie(@RequestBody() Director director){
        String name=director.getName();
        service.addDirectorInService(name,director);
        return new ResponseEntity<>("success message wrapped in a ResponseEntity object",HttpStatus.OK);
    }

    @GetMapping("/get_movie_by_name/{name}")
    public Movie getMovieByName(@PathVariable("name") String name){
        return service.getMovieByNameformService(name);
    }

    @GetMapping("/get_director_by_name/{name}")
    public Director getDirectorByName(@PathVariable("name") String name){
        return service.getDirectorByNameformService(name);
    }

    @PutMapping("/add_movie_director_pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestBody() Movie movie,Director director){
        String m=movie.getName();
        String d=director.getName();
        service.addinPair(d,m);
        return new ResponseEntity<>(" Director object wrapped in a ResponseEntity object",HttpStatus.OK);

    }
    @GetMapping("/get_movies_by_director_name/{name}")
    public ArrayList<String> getMoviesByDirectorName(@PathVariable() String name){
        return service.getListFromService(name);
    }
    @GetMapping("/get_all_movies")
    public ArrayList<Movie> findAllMovies(){
        return service.getallMoviesformservice();
    }
    @DeleteMapping("/delete_director_by_name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String name){
        service.deleteDirectorByNameformservice(name);
        return new ResponseEntity<>(" success message wrapped in a ResponseEntity object",HttpStatus.OK);
    }

    @DeleteMapping("/delete_all_directors")
    public ResponseEntity<String> deleteAllDirectors(){
        service.deleteAllDirectorsfromsevice();
        return new ResponseEntity<>(" success message wrapped in a ResponseEntity object",HttpStatus.OK);
    }

}
