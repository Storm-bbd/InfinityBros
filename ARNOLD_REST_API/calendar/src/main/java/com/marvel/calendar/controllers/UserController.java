package com.marvel.calendar.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.marvel.calendar.entities.MoviesEntity;
import com.marvel.calendar.entities.UsersEntity;
import com.marvel.calendar.repository.MovieRepository;
import com.marvel.calendar.repository.UserRepository;
import com.marvel.calendar.models.Users;
import com.marvel.calendar.models.Movies;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Arnold Hendricks
 */


@RestController
@RequestMapping("/api/v1")
@Api(value="Marvel Calendar Management System", description="CRUD REST APIs for Marvel Calendar Users with assigned Movies")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;

    
    @ApiOperation(value = "View a list of all users")
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<Users> getUsers() {
        List<UsersEntity> users = this.userRepository.findAll();
        return users.stream().map(user -> this.modelMapper.map(user, Users.class)).collect(Collectors.toList());
    }


    @ApiOperation(value = "Create a new user", response = List.class)
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public Users createMovie(@RequestBody Users model) {
       UsersEntity user = new UsersEntity();
       user.setEmail(model.getEmail());
       user.setPassword(model.getPassword());

       userRepository.save(user);

       return modelMapper.map(user, Users.class);
    }

    @ApiOperation(value = "Update a user")
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Users updateMovie(@PathVariable("id") int id, @RequestBody Users model) {
        //Optional<UsersEntity> userOptional = userRepository.findById(id);

        // if (!movieOptional.isPresent())
        //     return ResponseEntity.notFound().build();
    
        model.setId(id);
        
        UsersEntity user = this.userRepository.findById(id).get();
         user.setEmail(model.getEmail());
         user.setPassword(model.getPassword());

       userRepository.save(user);
       return modelMapper.map(user, Users.class);
        //return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Add a movie to a user")
    @PutMapping("/users/addmovie/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Users addMovieUser(@PathVariable("id") int id, @RequestBody Movies model) {
        //Optional<UsersEntity> userOptional = userRepository.findById(id);

        // if (!movieOptional.isPresent())
        //     return ResponseEntity.notFound().build();
    
        //model.setId(id);

        MoviesEntity movie = this.movieRepository.findById(model.getId()).get();
        
        UsersEntity user = this.userRepository.findById(id).get();
         user.addUserMovies(movie);

       userRepository.save(user);
       return modelMapper.map(user, Users.class);
        //return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete a user")
    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMovie(@PathVariable("id") int id) {
       userRepository.deleteById(id);
    }

    @ApiOperation(value = "Delete a user movie")
    @DeleteMapping("/users/deletemovie/{user_id}/{movie_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserMovie(@PathVariable("user_id") int user_id, @PathVariable("movie_id") int movie_id) {

        MoviesEntity movie = this.movieRepository.findById(movie_id).get();

        UsersEntity user = this.userRepository.findById(user_id).get();
         user.removeUserMovies(movie);

         userRepository.save(user);
    }

}
