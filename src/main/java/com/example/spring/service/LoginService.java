package com.example.spring.service;

import com.example.spring.entities.User;

public class LoginService {

    public LoginService(){}

    public boolean createUser(String email,String password){
        boolean res=false;
        String sql = "INSERT INTO USERS (USER_EMAIL,USER_PASSWORD) VALUES ("+email+","+password+")";
        //do db call
//        try{
//            //call to db lnk
//        }catch(Exception e){
//
//        }finally {
//            return res;
//        }
    }

    public User Login(String email, String password){
        User user = null;
        String sql = "SELECT * FROM USERS WHERE EMAIL="+email+" AND PASSWORD="+password;
        //call to db
        //if there is a user in the database map it to a user object and return to the user
//        try{
//            //call to db link
//        }catch (Exception e){
//
//        }finally {
//            return user;
//        }
    }
}
