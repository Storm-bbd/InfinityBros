package com.example.spring.controller;

import com.example.spring.entities.MCUMovie;
import com.example.spring.entities.User;
import com.example.spring.entities.UserMovies;

import java.util.ArrayList;

import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;

public class ProfileController {

    private User user = null;
    private ArrayList<UserMovies> userMovies = new ArrayList<UserMovies>();
    private ArrayList<MCUMovie> movies = new ArrayList<MCUMovie>();

    private void getMovies(int userID){
        //sql call to get user movies that match user ID and add all entries to userMovies
        //get sqlcall for all movies in usermovie
    }


    @RequestMapping(value = "/movies-watched", method = POST)
    public ArrayList<MCUMovie> getUnwatchedMovies(){
        ArrayList<MCUMovie> unwatchedMovies = new ArrayList<MCUMovie>();
        for(int i=0;i<this.userMovies.size();i++){
            if (!this.userMovies.get(i).isChecked()){
                int index = getIndexOf(this.userMovies.get(i).getTitle());
                if (index>-1){
                    unwatchedMovies.add(movies.get(index));
                }
            }
        }
        return unwatchedMovies;
    }

    @RequestMapping(value = "/movies-watched", method = POST)
    public ArrayList<MCUMovie> getWatchedMovies(){
        ArrayList<MCUMovie> watchedMovies = new ArrayList<MCUMovie>();
        for(int i=0;i<this.userMovies.size();i++){
              if (this.userMovies.get(i).isChecked()){
                  int index = getIndexOf(this.userMovies.get(i).getTitle());
                  if (index>-1){
                      watchedMovies.add(movies.get(index));
                  }
              }
        }
        return watchedMovies;
    }

    private int getIndexOf(String title){
        for(int j=0;j<this.movies.size();j++){
            if(this.movies.get(j).getMovieName()==title)
                return j;
        }
        return -1;
    }

}



