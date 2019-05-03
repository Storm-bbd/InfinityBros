package com.example.spring.entities;

import javax.persistence.*;

@Entity
@Table(name = "MCUMovies")
public class MCUMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movieID")
    private Integer movieID;
    @Column(name = "movieName")
    private String movieName;
    @Column(name = "moviePosterURL")
    private String moviePosterURL;
    @Column(name = "movieTrailerURL")
    private String movieTrailerURL;
    @Column(name = "movieReleaseDate")
    private String movieReleaseDate;

    public MCUMovie() {
        super();
    }

    public MCUMovie(String movieName, String moviePosterURL, String movieTrailerURL, String movieReleaseDate) {
        this.movieName = movieName;
        this.moviePosterURL = moviePosterURL;
        this.movieTrailerURL = movieTrailerURL;
        this.movieReleaseDate = movieReleaseDate;
    }

    public Integer getMovieID() {
        return movieID;
    }

    public void setMovieID(Integer movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMoviePosterURL() {
        return moviePosterURL;
    }

    public void setMoviePosterURL(String moviePosterURL) {
        this.moviePosterURL = moviePosterURL;
    }

    public String getMovieTrailerURL() {
        return movieTrailerURL;
    }

    public void setMovieTrailerURL(String movieTrailerURL) {
        this.movieTrailerURL = movieTrailerURL;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    @Override
    public String toString() {
        return "MCUMovie{" +
                "movieID=" + movieID +
                ", movieName='" + movieName + '\'' +
                ", moviePosterURL='" + moviePosterURL + '\'' +
                ", movieTrailerURL='" + movieTrailerURL + '\'' +
                ", movieReleaseDate='" + movieReleaseDate + '\'' +
                '}';
    }
}
