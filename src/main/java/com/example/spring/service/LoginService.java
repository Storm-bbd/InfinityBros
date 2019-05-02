package com.example.spring.service;

import com.example.spring.entities.User;

public class LoginService {

    public LoginService(){}

    public boolean createUser(String email,String password){
        boolean res=false;
        try{
            //call to db lnk
        }catch(Exception e){

        }finally {
            return res;
        }
    }

    public User Login(String email, String password){
        User user = null;
        try{
            //call to db link
        }catch (Exception e){

        }finally {
            return user;
        }
    }
}
