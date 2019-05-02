package com.marvel.calendar.controllers;

import com.marvel.calendar.models.Movies;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.marvel.calendar.entities.MoviesEntity;
import com.marvel.calendar.repository.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Arnold Hendricks
 */


@RestController
@RequestMapping("/api/v1")
@Api(value="Marvel Calendar Management System", description="CRUD REST APIs for Marvel Calendar Movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;

    
    @ApiOperation(value = "View a list of all movies", response = List.class)
    @GetMapping("/movies")
    @ResponseStatus(HttpStatus.OK)
    public List<Movies> getUsers() {
        List<MoviesEntity> movies = this.movieRepository.findAll();
        return movies.stream().map(movie -> this.modelMapper.map(movie, Movies.class)).collect(Collectors.toList());
    }

    @ApiOperation(value = "Create a new movie", response = List.class)
    @PostMapping("/movies")
    @ResponseStatus(HttpStatus.OK)
    public Movies createMovie(@RequestBody Movies model) {
       MoviesEntity movie = new MoviesEntity();
       movie.setTitle(model.getTitle());
       movie.setReleaseDate(model.getReleaseDate());
       movie.setChronoOrder(model.getChronoOrder());

       movieRepository.save(movie);

       return modelMapper.map(movie, Movies.class);
    }

    @ApiOperation(value = "Update a movie")
    @PutMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movies updateMovie(@PathVariable("id") int id, @RequestBody Movies model) {
        //Optional<MoviesEntity> movieOptional = movieRepository.findById(id);

        // if (!movieOptional.isPresent())
        //     return ResponseEntity.notFound().build();
    
        model.setId(id);
        
        MoviesEntity movie = this.movieRepository.findById(id).get();
         movie.setTitle(model.getTitle());
       movie.setReleaseDate(model.getReleaseDate());
       movie.setChronoOrder(model.getChronoOrder());

       movieRepository.save(movie);
       return modelMapper.map(movie, Movies.class);
        //return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete a new movie")
    @DeleteMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMovie(@PathVariable("id") int id) {
       movieRepository.deleteById(id);
    }
}
