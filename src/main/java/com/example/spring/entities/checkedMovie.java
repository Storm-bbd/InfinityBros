package com.example.spring.entities;

public class checkedMovie {

    MCUMovie movie;
    boolean checked=false;

    public checkedMovie(MCUMovie movie){
        this.movie=movie;
    }

    public boolean setChecked(boolean check){
        this.checked = check;
    }

    public boolean isChecked(){
        return this.checked;
    }

    public MCUMovie getMovie() {
        return movie;
    }
}
