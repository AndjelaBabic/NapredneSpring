/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.client.controller;

import com.nst.domain.User;
import com.nst.dto.CardDTO;
import com.nst.dto.ListDTO;
import com.nst.dto.UserDTO;
import com.nst.service.ListService;
import com.nst.service.UserService;
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
public class ListController {
    
    @Autowired
    private ListService service;
    
    
    @RequestMapping(value = "/getlists", method = RequestMethod.GET)
    public @ResponseBody Object getListsForTheBoard(@RequestParam String boardId) {
         List<com.nst.domain.List> lists = service.getAllListsForTheBoard(boardId);
        return ResponseEntity.status(HttpStatus.OK).body(lists);
    }
    
    @RequestMapping(value = "/addList", method = RequestMethod.POST)
    public @ResponseBody Object addList(@RequestBody ListDTO list) {
        try {
            System.out.println("list "+list.getBoardid() + " listid "+ list.getListid());
            service.addList(list);    
            return ResponseEntity.status(HttpStatus.OK).body("Successfully inserted");
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error.");
        }
    }
    
    @RequestMapping(value = "/editListTitle", method = RequestMethod.PUT)
    public @ResponseBody Object editListTitle(@RequestBody ListDTO list) {
        try {
            System.out.println(list);
            service.editListTitle(list);    
            return ResponseEntity.status(HttpStatus.OK).body("Successfully edited list");
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occured during list edit");
        }
    }
    
     @RequestMapping(value = "/deleteList", method = RequestMethod.DELETE)
    public @ResponseBody Object deleteList(@RequestBody ListDTO list) {
        try {
            System.out.println(list);
            service.deleteList(list);    
            return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted list");
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occured during list delete");
        }
    }

}
