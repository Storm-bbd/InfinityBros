package com.marvel.calendar.entities;

import java.util.List;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * Created by Arnold Hendricks
 */

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "user_id"))
public class UsersEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;

	@ManyToMany
	@JoinTable(name = "usermovies",
		joinColumns = { @JoinColumn(name = "user_id") },
		inverseJoinColumns = { @JoinColumn(name = "movie_id") })
	private List<MoviesEntity> movies = new ArrayList<MoviesEntity>();


	public UsersEntity() { }
	
	public UsersEntity(String email, String password, List<MoviesEntity> movies) {
		this.email = email;
		this.password = password;
		this.movies = movies;
	}

	public int getId() {
		return user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<MoviesEntity> getMovies() {
		return movies;
	}

	public void setMovies(List<MoviesEntity> movies) {
		this.movies = movies;
	}

	public void addUserMovies(MoviesEntity movie) {
		this.movies.add(movie);
	}

	public void removeUserMovies(MoviesEntity movie) {
		this.movies.remove(movie);
	}

}
