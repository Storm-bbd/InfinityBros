package com.example.spring.controller;

import com.example.spring.entities.User;
import com.example.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;
import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;

public class LoginController {
    @Autowired
    LoginService loginService;


    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public boolean createUser(
            @RequestParam(value = "email", required= true) String email,
            @RequestParam(value ="password",required=true) String password){
        return loginService.createUser(email,password);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public boolean login(
            @RequestParam(value = "email", required= true) String email,
            @RequestParam(value ="password",required=true) String password){
        User user = loginService.Login(email,password);
        if(user!=null)
            return true;
        return false;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(){
     //perform a redirect to login page
    }
}
