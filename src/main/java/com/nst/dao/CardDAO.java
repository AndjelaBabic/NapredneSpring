/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.dao;

import com.nst.domain.Card;
import java.util.Date;
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
public interface CardDAO extends JpaRepository<Card, Integer> {
    
    @Transactional
    @Modifying
    @Query(value=
            "INSERT INTO card (cardid, title, description, priority, duedate, label, listid) "
            +"VALUES (:cardid, :title, :description, :priority, :duedate, :label, :listid)", 
            nativeQuery = true)
    void addCard(@Param("cardid") String cardid, @Param("title") String title, 
            @Param("description") String description, @Param("priority") String priority,
            @Param("duedate") Date duedate, @Param("label") String label,
            @Param("listid") String listid);
}
