package com.marvel.calendar.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by Arnold Hendricks
 */


@Entity
@Table(name = "movies", uniqueConstraints = @UniqueConstraint(columnNames = "movie_id"))
public class MoviesEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movie_id;
	
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "release_date")
    private String release_date;
    
    @Column(name = "chrono_order")
	private int chrono_order;

    @ManyToMany(mappedBy="movies")
private List<UsersEntity> users = new ArrayList<UsersEntity>();

	public MoviesEntity() { }
	
	public MoviesEntity(String title, String release_date, int chrono_order) {
		this.title = title;
        this.release_date = release_date;
        this.chrono_order = chrono_order;
	}   

	public int getId() {
		return movie_id;
	}

/*
	public void setId(int id) {
		this.id = id;
	}
*/

	public String getTitle() {
		return title;
    }
    
    public void setTitle(String title) {
		this.title = title;
	}


    public String getReleaseDate() {
		return release_date;
    }
    
	public void setReleaseDate(String release_date) {
		this.release_date = release_date;
	}

	public int getChronoOrder() {
		return chrono_order;
	}

	public void setChronoOrder(int chrono_order) {
		this.chrono_order = chrono_order;
	}

}
