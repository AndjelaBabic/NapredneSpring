/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service.impl;

import com.nst.dao.BoardDAO;
import com.nst.domain.Board;
import com.nst.domain.User;
import com.nst.dto.BoardDTO;
import com.nst.dto.UserDTO;
import com.nst.service.BoardService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andjela Babic
 */
@Service
public class BoardServiceImpl implements BoardService{
    
    @Autowired
    BoardDAO repository; 
    
    @Override
    public void addBoard(BoardDTO board) {
        Date now = new Date();
        repository.addBoard(board.getBoardId(), board.getTitle(),
               now, now, board.getUserId());
    }
    
}
