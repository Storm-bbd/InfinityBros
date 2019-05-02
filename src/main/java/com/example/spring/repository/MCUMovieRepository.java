package com.example.spring.repository;

import com.example.spring.entities.MCUMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MCUMovieRepository extends JpaRepository<MCUMovie, Integer> {
}
