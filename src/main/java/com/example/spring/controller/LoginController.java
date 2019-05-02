package com.example.spring.controller;

import com.example.spring.entities.User;
import com.example.spring.service.LoginService;

import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;
import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;

public class LoginController {
    @Autowired
    LoginService loginService;


    @RequestMapping(value = "/create-user", method = POST)
    public boolean createUser(
            @RequestParam(value = "email", required= true) String email,
            @RequestParam(value ="password",required=true) String password){
        return loginService.createUser(email,password);
    }

    @RequestMapping(value = "/login", method = GET)
    public boolean login(
            @RequestParam(value = "email", required= true) String email,
            @RequestParam(value ="password",required=true) String password){
        User user = loginService.Login(email,password);
        if(user!=null)
            return true;
        return false;
    }

    @RequestMapping(value = "/logout", method = POST)
    public void logout(){
        
    }
}
