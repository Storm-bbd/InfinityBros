package com.example.spring.entities;

import java.util.ArrayList;

public class UserMovies {
    private ArrayList<checkedMovie> movies;

    public UserMovies(){
        this.movies = new ArrayList<checkedMovie>();
    }

    public void addMovie(MCUMovie movie){
        checkedMovie mov = new checkedMovie(movie);
        movies.add(mov);
    }

    public checkedMovie getMovie(String title){
        return movies.get(getIndexOf(title));
    }

    public checkedMovie getMovie(int index){
        return movies.get(index);
    }

    public int getIndexOf(String title){
        int i =0;
        for (int j =0;j<movies.size();j++)
            if (movies.get(i).getMovie().getMovieName()==title)
                return i;
        return -1;
    }

    public boolean removeMovie(String title){
        int i = getIndexOf(title);
        if (i>-1){
            movies.remove(i);
            return true;
        }
        return false;
    }

    public boolean checkMovie(String title,boolean check){
        int i = getIndexOf(title);
        if(i>-1){
            movies.get(i).setChecked(check);
            return  true;
        }
        return false;
    }
}
