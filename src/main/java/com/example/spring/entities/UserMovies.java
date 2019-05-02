package com.example.spring.entities;

import java.util.ArrayList;

public class UserMovies {

    int movie_id;
    int user_id;
    String title;
    String email;
    boolean checked;

    public UserMovies(int movie_id,int user_id,String title,String email, boolean checked){
        this.movie_id = movie_id;
        this.user_id=user_id;
        this.title = title;
        this.email=email;
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
