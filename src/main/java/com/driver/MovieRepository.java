package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieDB=new HashMap<>();
    HashMap<String,Director> directorBD=new HashMap<>();
    HashMap<String, ArrayList<String>> pairDB=new HashMap<>();
    public void addMovieInDB(String name,Movie m){
        movieDB.put(name,m);
    }
    public void addDirectorInDB(String name,Director d){
        directorBD.put(name,d);
    }
    public Movie getMovieByNameformDB(String name){
        return movieDB.get(name);
    }

    public Director getDirectorByNameformDB(String name){
        return directorBD.get(name);
    }

    public void addPair(String d,String m){
        if(!pairDB.containsKey(d))
            pairDB.put(d,new ArrayList<>());
        pairDB.get(d).add(m);
    }

    public ArrayList<String> getListFromDB(String name){
        return pairDB.get(name);
    }
    public ArrayList<String> getallMoviesformDB(){
        ArrayList<String> movies=new ArrayList<>();
        for(Movie m:movieDB.values())
            movies.add(m.getName());

        return movies;
    }
    public void deleteDirectorByNamefromDB(String director){
        ArrayList<String> name=pairDB.get(director);
        pairDB.remove(director);
        directorBD.remove(director);
        for(String n:name){
            movieDB.remove(n);
        }
    }

    public void deleteAllDirectorsfromBD(){
        ArrayList<String> director=new ArrayList<>();
        ArrayList<String> movie=new ArrayList<>();
        for(String n:directorBD.keySet())
            director.add(n);
        directorBD.clear();

        for(String directorname:director){
            if(pairDB.containsKey(directorname)){
                for(String moviename:pairDB.get(directorname))
                     movie.add(moviename);
            }
        }

        directorBD.clear();
        for(String name:movie){
            if(movieDB.containsKey(name)){
                movieDB.remove(name);
            }
        }


    }


}
