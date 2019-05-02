package com.marvel.calendar.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 * Created by Arnold Hendricks
 */


public class Movies {
    @NotEmpty
    @NotNull
    @PositiveOrZero
    private int movies_id;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String release_date;

    @NotNull
    @NotEmpty
    private int chrono_order;




    public int getId() {
        return movies_id;
    }

    public void setId(int movies_id) {
        this.movies_id = movies_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(String release_date) {
        this.release_date = release_date;
    }

    public int getChronoOrder() {
        return chrono_order;
    }

    public void setChronoOrder(int chrono_order) {
        this.chrono_order = chrono_order;
    }


}