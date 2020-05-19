/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.dao;
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
public interface ListDAO extends JpaRepository<List, Integer> {
    
    @Query("SELECT l FROM List l")
    java.util.List<List> getAllListsForTheBoard(String boardId);

    @Transactional
    @Modifying
    @Query(value=
            "INSERT INTO list (listid, title, boardid) "
            +"VALUES (:listid, :title, :boardid)", 
            nativeQuery = true)
    void addList(@Param("listid") String listid, @Param("title") String title, 
            @Param("boardid") String boardid);
    
    @Transactional
    @Modifying
    @Query("UPDATE List l SET l.title=?1 WHERE l.listid=?2")
    void editListTitle(String title, String listid);
}
