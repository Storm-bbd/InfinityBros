package com.example.spring.controller;

import com.example.spring.entities.MCUMovie;
import com.example.spring.entities.User;
import com.example.spring.repository.MCUMovieRepository;
import com.example.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private MCUMovieRepository mcuMovieRepository;

    @Autowired
    private UserRepository userRepository;

    private String user_ID;

    boolean isInitialised = false;

    @RequestMapping("/")
    public String showSignInPage() {
        return "index";
    }

    @RequestMapping("/signup")
    public String showSignUpPage() {
        return "signup";
    }

    @RequestMapping("/home")
    public String showPage() {
        return "home";
    }

    @RequestMapping("/profile")
    public String showPagee() {
        return "profile";
    }

    @RequestMapping("/calendar")
    public String showPagewe() {
        return "calendar";
    }

    @PostMapping("/user")
    public String addUser(@RequestBody User user) {
        userRepository.save(user);
        return "User successfully added...";
    }

    @ModelAttribute("MCUMovies")
    public List<MCUMovie> selectAllMovies() {

        dbController db=dbController.getInstance();
        return db.selectAllMovies();
    }
    @ModelAttribute("signin")
    public void signIn(@ModelAttribute("email") String email,@ModelAttribute("password") String password){
        dbController db=dbController.getInstance();
        int user=db.login("storm@bbd.co.za","Test123");
        if(user!=0){
            user_ID=Integer.toString(user);
        }
    }
    @ModelAttribute("LikedMovies")
    public List<MCUMovie> getLiked() {
        dbController db=dbController.getInstance();
        return db.getLiked(user_ID);
    }

    @ModelAttribute("WatchList")
    public List<MCUMovie> getWatchList() {
        dbController db=dbController.getInstance();
        return db.getChecked(user_ID);
    }

    @ModelAttribute("WatchedMovies")
    public List<MCUMovie> getWatched() {
        dbController db=dbController.getInstance();
        return db.getChecked(user_ID);
    }

}
