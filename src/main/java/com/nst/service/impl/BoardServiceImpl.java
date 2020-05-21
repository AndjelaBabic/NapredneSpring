/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service.impl;

import com.nst.dao.BoardDAO;
import com.nst.domain.Board;
import com.nst.domain.Card;
import com.nst.domain.User;
import com.nst.dto.BoardDTO;
import com.nst.dto.ListDTO;
import com.nst.dto.UserDTO;
import com.nst.service.BoardService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @Override
    public List<BoardDTO> getBoardsForUser(int userid) {
        User currentUser = new User(userid); 
        List<Board> result = repository.getAllBoardsByUsedId(currentUser);
        List<BoardDTO> returnList = new ArrayList<>();
        for (Board board : result) {
            BoardDTO newBoard = new BoardDTO(); 
            newBoard.setBoardId(board.getBoardid());
            newBoard.setCreated(board.getCreated());
            newBoard.setModified(board.getModified());
            newBoard.setTitle(board.getTitle());
            String [] listIds = new String[board.getListList().size()];
            int i = 0; 
            for (com.nst.domain.List list : board.getListList()) {
                listIds[0] = list.getListid(); 
                i++; 
            }
            newBoard.setListIds(listIds);
            returnList.add(newBoard);
        }
           return returnList;
        }
    
}
