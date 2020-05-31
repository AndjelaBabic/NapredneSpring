/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.controllers;

/**
 *
 * @author Andjela Babic
 */
import com.nst.client.controller.CardController;
import com.nst.client.controller.UserController;
import com.nst.dto.CardDTO;
import com.nst.dto.UserDTO;
import com.nst.payload.ApiResponse;
import com.nst.service.CardService;
import com.nst.service.UserService;
import com.nst.util.Messages;
import java.util.Collection;
import java.util.List;
import javax.validation.constraints.AssertTrue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.springframework.http.HttpStatus;
import static org.mockito.Mockito.*;
import java.util.Collections; 
import javax.management.RuntimeErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardControllerTest {
 
    public final String ERROR_GET_ALL_CARDS = Messages.ERROR_GET + "card"; 
    public final String SUCCESS_EDIT_CARD_LIST = Messages.SUCCESS_UPDATE + " card list";
     public final String SUCCESS_EDIT_CARD_TITLE = Messages.SUCCESS_UPDATE + " card title";
    
    @InjectMocks
    CardController cardController; 
    
    @Mock
    CardService cardService; 
    
    @Test
    public void testGetAllCardsEmptyList(){
        List cards = Collections.EMPTY_LIST; 
        when(cardService.getAllCards()).thenReturn(cards); 
        ResponseEntity response = (ResponseEntity) cardController.getCards(); 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cards, response.getBody());
    }
    
    @Test
    public void testGetAllCards(){
        List<CardDTO> cards = Collections.singletonList(new CardDTO());
        when(cardService.getAllCards()).thenReturn(cards); 
        ResponseEntity response = (ResponseEntity) cardController.getCards(); 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cards, response.getBody());
    }
    
    @Test
    public void testGetAllCardsFailed(){
        List<CardDTO> cards = Collections.singletonList(new CardDTO());
        doThrow(RuntimeErrorException.class).when(cardService).getAllCards();
        ResponseEntity response = (ResponseEntity) cardController.getCards(); 
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertTrue(response.getBody() instanceof ApiResponse);
        assertEquals(ERROR_GET_ALL_CARDS, ((ApiResponse) response.getBody()).getMessage());
    }
    
    @Test
    public void testEditCardList(){
        CardDTO card = new CardDTO();
        card.setCardid("card-01");
        card.setListid("list-01");
        ResponseEntity response = (ResponseEntity) cardController.editCardList(card); 
        verify(cardService, times(1)).editCardList(card);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof ApiResponse);
        assertEquals(SUCCESS_EDIT_CARD_LIST, ((ApiResponse) response.getBody()).getMessage());
    }
    
        @Test
    public void testEditCardTitle(){
        CardDTO card = new CardDTO();
        card.setCardid("card-01");
        card.setTitle("Some title");
        ResponseEntity response = (ResponseEntity) cardController.editCardTitle(card); 
        verify(cardService, times(1)).editCardTitle(card);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof ApiResponse);
        assertEquals(SUCCESS_EDIT_CARD_TITLE, ((ApiResponse) response.getBody()).getMessage());
    }
    
}
