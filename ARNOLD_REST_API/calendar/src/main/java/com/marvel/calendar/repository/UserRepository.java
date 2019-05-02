package com.marvel.calendar.repository;

import com.marvel.calendar.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Arnold Hendricks
 */

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Integer> {

}
