/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service;

import com.nst.domain.Board;
import com.nst.dto.BoardDTO;
import com.nst.dto.UserDTO;
import java.util.List;

/**
 *
 * @author Andjela Babic
 */
public interface BoardService {
    
    public void addBoard(BoardDTO board);
    
    public List<Board> getBoardsForUser(int userid); 
}
