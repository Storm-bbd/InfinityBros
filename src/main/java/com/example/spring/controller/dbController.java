package com.example.spring.controller;


import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.spring.entities.MCUMovie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class dbController {
    public static Connection connection=null;
    final static Logger logger = LoggerFactory.getLogger(dbController.class);

    private static volatile dbController instance;

    private dbController(){
        connection=connect();
    }


    private Connection connect() {
        // Do Tomorrow
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
        }catch(Exception e){
            System.out.println("Instance creation failed");
        }

        String url = "jdbc:sqlite:"+System.getProperty("user.home") + "\\marveldb.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            logger.info(url);
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
        return conn;
    }
    public void insertUser(String username, String Password) {
        String sql = "INSERT INTO Users (EMAIL,PASSWORD) "
                + "values (?,?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1,username);
            pstmt.setString(2,Password);;
            pstmt.executeUpdate();
            logger.info("Activity recorded");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<MCUMovie> getLiked(String username){
        String sql = "SELECT * FROM UserMovies WHERE LIKED=1 and USER_ID=?";
        ResultSet rs=null;
        List<MCUMovie> records = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1,username);
            rs = pstmt.executeQuery();
            logger.info("liked recorded");


            while (rs.next()) {

                String movieID = rs.getString("MOVIE_ID");
                String movieName = rs.getString("TITLE");
                String moviePoster = rs.getString("POSTER_URL");
                String movieTrailer = rs.getString("TRAILER_URL");
                String movieRelease = rs.getString("RELEASE_DATE");
                String userID =username;
                records.add(new MCUMovie(movieID,movieName,moviePoster,movieTrailer,movieRelease));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return records;

    }
    public List<MCUMovie> getChecked(String username){
        String sql = "SELECT * FROM UserMovies WHERE CHECKED=1 AND USER_ID=?";
        ResultSet rs=null;
        List<MCUMovie> records = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1,username);
            rs = pstmt.executeQuery();
            logger.info("checked recorded");


            while (rs.next()) {

                String movieID = rs.getString("MOVIE_ID");
                String movieName = rs.getString("TITLE");
                String moviePoster = rs.getString("POSTER_URL");
                String movieTrailer = rs.getString("TRAILER_URL");
                String movieRelease = rs.getString("RELEASE_DATE");
                String userID =username;
                records.add(new MCUMovie(movieID,movieName,moviePoster,movieTrailer,movieRelease));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return records;

    }
    public List<MCUMovie> selectAllMovies(){

        String sql = "SELECT * FROM TBL_MOVIES";
        ResultSet rs=null;
        List<MCUMovie> records = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            rs = pstmt.executeQuery();
            logger.info("select recorded");


            while (rs.next()) {

                String movieID = rs.getString("MOVIE_ID");
                String movieName = rs.getString("TITLE");
                String moviePoster = rs.getString("POSTER_URL");
                String movieTrailer = rs.getString("TRAILER_URL");
                String movieRelease = rs.getString("RELEASE_DATE");
                records.add(new MCUMovie(movieID,movieName,moviePoster,movieTrailer,movieRelease));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return records;
    }
    public int login(String username,String password){

        String sql = "SELECT * FROM USERS where ? == USERS.EMAIL";
        ResultSet rs=null;
        List<String> records = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1,username);
            rs = pstmt.executeQuery();
            logger.info("login recorded");


            while (rs.next()) {
                int user_ID=rs.getInt("USER_ID");
                String email = rs.getString("EMAIL");
                String passDB = rs.getString("PASSWORD");
                if(passDB.equals(password)){
                    return user_ID;
                }else{
                    return 0;
                }
            }
            return 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public static dbController getInstance(){
        if(connection==null){
            instance=new dbController();
        }
        return instance;
    }

}

