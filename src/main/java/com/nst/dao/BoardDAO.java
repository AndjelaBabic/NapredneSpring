/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.dao;

import com.nst.domain.Board;
import com.nst.domain.List;
import com.nst.domain.User;
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
public interface BoardDAO extends JpaRepository<Board, Integer> {
    
    @Transactional
    @Modifying
    @Query(value=
            "INSERT INTO board (boardId, title, modified, created, userId) "
            +"VALUES (:boardId, :title, :modified, :created, :userId)", 
            nativeQuery = true)
    void addBoard(@Param("boardId") String boardId, @Param("title") String title, 
            @Param("modified") Date modified, @Param("created") Date created, @Param("userId") int userId);
    
}
