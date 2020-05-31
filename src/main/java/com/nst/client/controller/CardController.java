/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.client.controller;
import com.nst.domain.Board;
import com.nst.domain.Card;
import com.nst.dto.BoardDTO;
import com.nst.dto.CardDTO;
import com.nst.dto.ListDTO;
import com.nst.payload.ApiResponse;
import com.nst.service.CardService;
import com.nst.util.Messages;
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
public class CardController {
    
    @Autowired 
    private CardService service; 

    @RequestMapping(value = "/getCards", method = RequestMethod.GET)
    public @ResponseBody Object getCards() {
        try {
            List<CardDTO> result = service.getAllCards();    
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, Messages.ERROR_GET + "card" ));
        }
    }
    
    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public @ResponseBody Object addCard(@RequestBody CardDTO card) {
        try {
            System.out.println(card);
            service.addCard(card);    
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true, "Card "+Messages.SUCCESS_INSERT ));
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(true, Messages.ERROR_INSERT + "card" ));
        }
    }
    
    @RequestMapping(value = "/editCardTitle", method = RequestMethod.PUT)
    public @ResponseBody Object editCardTitle(@RequestBody CardDTO card) {
        try {
            service.editCardTitle(card);    
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse((true), Messages.SUCCESS_UPDATE + " card title"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, Messages.ERROR_UPDATE + " card title"));
        }
    }
    
    @RequestMapping(value = "/editCardList", method = RequestMethod.PUT)
    public @ResponseBody Object editCardList(@RequestBody CardDTO card) {
        try {
            service.editCardList(card);    
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse((true), Messages.SUCCESS_UPDATE + " card list"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, Messages.ERROR_UPDATE + " card list"));
        }
    }
    
    @RequestMapping(value = "/deleteCard", method = RequestMethod.DELETE)
    public @ResponseBody Object deleteCard(@RequestBody CardDTO card) {
        try {
            service.deleteCard(card);   
              return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse((true), Messages.SUCCESS_DELETE + " card"));
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse((false), Messages.ERROR_DELETE + " card")); 
        }
    }
}
