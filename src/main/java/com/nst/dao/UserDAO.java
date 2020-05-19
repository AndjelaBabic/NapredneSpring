/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.dao;

import com.nst.domain.User;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andjela Babic
 */
@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email= ?1 AND u.password = ?2")
    User login(String email, String password);
    
    @Transactional
    @Modifying
    @Query(value=
            "INSERT INTO user (fullname, email, password) "
            +"VALUES (:fullname, :email, :password)", 
            nativeQuery = true)
    void insertUser(@Param("fullname") String fullname, @Param("email") String email, 
            @Param("password") String password);
    
}
