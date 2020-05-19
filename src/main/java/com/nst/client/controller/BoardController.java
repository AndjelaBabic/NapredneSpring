/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.client.controller;

import com.nst.domain.Board;
import com.nst.domain.User;
import com.nst.dto.BoardDTO;
import com.nst.dto.UserDTO;
import com.nst.service.BoardService;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andjela Babic
 */
@RestController
@CrossOrigin
public class BoardController {
    
    @Autowired
    private BoardService service; 
    
    @RequestMapping(value = "/getBoards", method = RequestMethod.GET)
    public @ResponseBody Object getBoards(@RequestParam int userid) {
        try {
            List<Board> result = service.getBoardsForUser(userid);    
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while inserting Board");
        }
    }
    
    @RequestMapping(value = "/addBoard", method = RequestMethod.POST)
    public @ResponseBody Object addBoard(@RequestBody BoardDTO board) {
        try {
            service.addBoard(board);    
            return ResponseEntity.status(HttpStatus.OK).body("Successfuly inserted");
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while inserting Board");
        }
    }
}
