package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class MovieService {
    @Autowired
    MovieRepository repository;

    public void addMovieInService(String name,Movie m){
        repository.addMovieInDB(name,m);
    }

    public void addDirectorInService(String name,Director d){
        repository.addDirectorInDB(name,d);
    }
    public Movie getMovieByNameformService(String name){
        return repository.getMovieByNameformDB(name);
    }

    public Director getDirectorByNameformService(String name){
        return repository.getDirectorByNameformDB(name);
    }

    public void addinPair(String director,String name){
        repository.addPair(director,name);
    }
    public List<String> getListFromService(String name){
        return repository.getListFromDB(name);
    }
    public List<String>  getallMoviesformservice(){
        return repository.getallMoviesformDB();
    }
    public void deleteDirectorByNameformservice(String director){
       repository.deleteDirectorByNamefromDB(director);
    }

    public void deleteAllDirectorsfromsevice(){
        repository.deleteAllDirectorsfromBD();
    }

}
