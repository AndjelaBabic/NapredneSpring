/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.client.controller;
import com.nst.dto.BoardDTO;
import com.nst.dto.CardDTO;
import com.nst.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Andjela Babic
 */
@RestController
@CrossOrigin
public class CardController {
    
    @Autowired 
    private CardService service; 
    
    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public @ResponseBody Object addCard(@RequestBody CardDTO card) {
        try {
            System.out.println(card);
            service.addCard(card);    
            return ResponseEntity.status(HttpStatus.OK).body("Successfully inserted");
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error.");
        }
    }
}
