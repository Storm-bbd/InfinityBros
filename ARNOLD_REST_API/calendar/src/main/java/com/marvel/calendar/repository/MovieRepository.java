package com.marvel.calendar.repository;

import com.marvel.calendar.entities.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Arnold Hendricks
 */

@Repository
public interface MovieRepository extends JpaRepository<MoviesEntity, Integer> {

}