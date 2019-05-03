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

        if (!isInitialised) {
            initialize();
            isInitialised = true;
        }
        return mcuMovieRepository.findAll();
    }

    @ModelAttribute("LikedMovies")
    public List<MCUMovie> getLiked() {
        List<MCUMovie> list = new ArrayList<>();
        list.add(new MCUMovie("Avengers: Infinity War", "/img/movies/Avengers_Infinity_war.jpg", "https://www.youtube.com/embed/6ZfuNTqbHE8", "2018-04-27"));
        list.add(new MCUMovie("Ant-Man and the Wasp", "/img/movies/Ant-Man_and_the_Wasp.jpg", "https://www.youtube.com/embed/8_rTIAOohas", "2018-07-04"));
        list.add(new MCUMovie("Captain Marvel", "/img/movies/CaptainMarvel.jpg", "https://www.youtube.com/embed/Z1BCujX3pw8", "2019-03-08"));
        list.add(new MCUMovie("Avengers: Endgame", "/img/movies/Avengers_Endgame.jpg", "https://www.youtube.com/embed/hA6hldpSTF8", "2019-04-26"));
        list.add(new MCUMovie("Spider-Man: Far From Home", "/img/movies/Spidar_Man_Far_From_Home.jpg", "https://www.youtube.com/embed/VUFmhKpZKlE", "2019-07-02"));
        return list;
    }

    @ModelAttribute("WatchList")
    public List<MCUMovie> getWatchList() {
        List<MCUMovie> list = new ArrayList<>();
        list.add(new MCUMovie("Guardians of the Galaxy", "/img/movies/GuardiansoftheGalaxy.jpg", "https://www.youtube.com/embed/d96cjJhvlMA", "2014-08-01"));
        list.add(new MCUMovie("Avengers: Age of Ultron", "/img/movies/Avengers_Age_Of_Ultron.jpg", "https://www.youtube.com/embed/MZoO8QVMxkk", "2015-04-22"));
        list.add(new MCUMovie("Ant-Man", "/img/movies/Ant-Man.png", "https://www.youtube.com/embed/IEVE3KSKQ0o", "2015-07-14"));
        list.add(new MCUMovie("Captain America: Civil War", "/img/movies/Captain_America_Civil_War.jpg", "https://www.youtube.com/embed/43NWzay3W4s", "2016-04-27"));
        list.add(new MCUMovie("Doctor Strange", "/img/movies/DrStrange.jpg", "https://www.youtube.com/embed/HSzx-zryEgM", "2016-10-25"));
        return list;
    }

    @ModelAttribute("WatchedMovies")
    public List<MCUMovie> getWatched() {
        List<MCUMovie> list = new ArrayList<>();
        list.add(new MCUMovie("Iron Man", "/img/movies/Iron_Man.jpg", "https://www.youtube.com/embed/bK_Y5LjSJ-Y", "2008-04-30"));
        list.add(new MCUMovie("The Incredible Hulk", "/img/movies/The-Incredible-Hulk.jpg", "https://www.youtube.com/embed/xbqNb2PFKKA", "2008-06-13"));
        list.add(new MCUMovie("Iron Man 2", "/img/movies/Iron_Man_2.jpg", "https://www.youtube.com/embed/FNQowwwwYa0", "2010-04-28"));
        list.add(new MCUMovie("Thor", "/img/movies/Thor.jpg", "https://www.youtube.com/embed/JOddp-nlNvQ", "2011-04-27"));
        list.add(new MCUMovie("Captain America: The First Avenger", "/img/movies/CaptainAmericaTheFirstAvenger.jpg", "https://www.youtube.com/embed/JerVrbLldXw", "2011-07-22"));
        list.add(new MCUMovie("The Avengers", "/img/movies/The_avengers.jpg", "https://www.youtube.com/embed/eOrNdBpGMv8", "2012-04-24"));
        list.add(new MCUMovie("Iron Man 3", "/img/movies/Iron_Man_3.jpg", "https://www.youtube.com/embed/_UMVJ3wRqDg", "2013-04-24"));
        return list;
    }


    private void initialize() {
        List<MCUMovie> list = new ArrayList<>();
        list.add(new MCUMovie("Iron Man", "/img/movies/Iron_Man.jpg", "https://www.youtube.com/embed/bK_Y5LjSJ-Y", "/img/calendar/1.png"));
        list.add(new MCUMovie("The Incredible Hulk", "/img/movies/The-Incredible-Hulk.jpg", "https://www.youtube.com/embed/xbqNb2PFKKA", "/img/calendar/2.png"));
        list.add(new MCUMovie("Iron Man 2", "/img/movies/Iron_Man_2.jpg", "https://www.youtube.com/embed/FNQowwwwYa0", "/img/calendar/3.png"));
        list.add(new MCUMovie("Thor", "/img/movies/Thor.jpg", "https://www.youtube.com/embed/JOddp-nlNvQ", "/img/calendar/4.png"));
        list.add(new MCUMovie("Captain America: The First Avenger", "/img/movies/CaptainAmericaTheFirstAvenger.jpg", "https://www.youtube.com/embed/JerVrbLldXw", "/img/calendar/5.png"));
        list.add(new MCUMovie("The Avengers", "/img/movies/The_avengers.jpg", "https://www.youtube.com/embed/eOrNdBpGMv8", "/img/calendar/6.png"));
        list.add(new MCUMovie("Iron Man 3", "/img/movies/Iron_Man_3.jpg", "https://www.youtube.com/embed/_UMVJ3wRqDg", "/img/calendar/7.png"));
        list.add(new MCUMovie("Thor: The Dark World", "/img/movies/Thor_Un_Mundo_Oscuro_Poster.jpg", "https://www.youtube.com/embed/7p7rocHEecE", "/img/calendar/8.png"));
        list.add(new MCUMovie("Captain America: The Winter Soldier", "/img/movies/Captain_America_The_Winter_Soldier.jpg", "https://www.youtube.com/embed/7SlILk2WMTI", "/img/calendar/9.png"));
        list.add(new MCUMovie("Guardians of the Galaxy", "/img/movies/GuardiansoftheGalaxy.jpg", "https://www.youtube.com/embed/d96cjJhvlMA", "/img/calendar/10.png"));
        list.add(new MCUMovie("Avengers: Age of Ultron", "/img/movies/Avengers_Age_Of_Ultron.jpg", "https://www.youtube.com/embed/MZoO8QVMxkk", "/img/calendar/11.png"));
        list.add(new MCUMovie("Ant-Man", "/img/movies/Ant-Man.png", "https://www.youtube.com/embed/IEVE3KSKQ0o", "/img/calendar/12.png"));
        list.add(new MCUMovie("Captain America: Civil War", "/img/movies/Captain_America_Civil_War.jpg", "https://www.youtube.com/embed/43NWzay3W4s", "/img/calendar/13.png"));
        list.add(new MCUMovie( "Doctor Strange", "/img/movies/DrStrange.jpg", "https://www.youtube.com/embed/HSzx-zryEgM", "/img/calendar/14.png"));
        list.add(new MCUMovie("Guardians of the Galaxy Vol. 2", "/img/movies/GuardiansoftheGalaxyV2.jpg", "https://www.youtube.com/embed/sMTntxvok1M", "/img/calendar/15.png"));
        list.add(new MCUMovie("Spider-Man: Homecoming", "/img/movies/Spider_Man_Homecoming.jpg", "https://www.youtube.com/embed/rk-dF1lIbIg", "/img/calendar/16.png"));
        list.add(new MCUMovie("Thor: Ragnarok", "/img/movies/Thor_Ragnarok.jpg", "https://www.youtube.com/embed/ue80QwXMRHg", "/img/calendar/17.png"));
        list.add(new MCUMovie("Black Panther", "/img/movies/Black_Panther.jpg", "https://www.youtube.com/embed/xjDjIWPwcPU", "/img/calendar/18.png"));
        list.add(new MCUMovie("Avengers: Infinity War", "/img/movies/Avengers_Infinity_war.jpg", "https://www.youtube.com/embed/6ZfuNTqbHE8", "/img/calendar/19.png"));
        list.add(new MCUMovie("Ant-Man and the Wasp", "/img/movies/Ant-Man_and_the_Wasp.jpg", "https://www.youtube.com/embed/8_rTIAOohas", "/img/calendar/20.png"));
        list.add(new MCUMovie("Captain Marvel", "/img/movies/CaptainMarvel.jpg", "https://www.youtube.com/embed/Z1BCujX3pw8", "/img/calendar/21.png"));
        list.add(new MCUMovie("Avengers: Endgame", "/img/movies/Avengers_Endgame.jpg", "https://www.youtube.com/embed/hA6hldpSTF8", "/img/calendar/22.png"));
        list.add(new MCUMovie("Spider-Man: Far From Home", "/img/movies/Spidar_Man_Far_From_Home.jpg", "https://www.youtube.com/embed/VUFmhKpZKlE", "/img/calendar/23.png"));

        list.forEach(movie -> {
            mcuMovieRepository.save(movie);
        });;
    }
}
