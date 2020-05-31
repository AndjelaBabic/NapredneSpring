/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.services;

/**
 *
 * @author USER
 */
import com.nst.dao.CardDAO;
import com.nst.dto.CardDTO;
import com.nst.payload.ApiResponse;
import com.nst.service.CardService;
import com.nst.service.impl.CardServiceImpl;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.management.RuntimeErrorException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TestCardsServiceImpl {
    
    public static final Integer CARDID = 1;
    public static final String TITLE = "Andjela Babic";
    public static final String DESCRIPTION = "andjelasbabic@gmail.com";
    public static final String PRIORITY = "pass123";
    public static final String LABEL = "pass123";
    
    private String cardid;
    private String title;
    private String description;
    private String priority;
    private Date duedate;
    private String label;
    private String listid;
    
    @InjectMocks
    CardServiceImpl cardService; 
    
    @Mock
    CardDAO cardRepository; 
    
    @Test
    public void testAddCard(){
        CardDTO card = new CardDTO();
        card.setCardid(cardid);
        card.setDescription(DESCRIPTION);
        card.setTitle(TITLE);
        card.setDuedate(duedate);
        card.setPriority(PRIORITY);
        card.setLabel(LABEL);
        cardService.addCard(card);
        verify(cardRepository, times(1)).addCard(card.getCardid(), card.getTitle(), card.getDescription(),card.getPriority(), card.getDuedate(), card.getLabel(), card.getListid());
    }
    
    @Test
    public void testEditCardTitle(){
        CardDTO card = new CardDTO();
        card.setCardid(cardid);
        card.setTitle(TITLE);
        cardService.editCardTitle(card);
        verify(cardRepository, times(1)).editCardTitle(card.getTitle(), card.getCardid());
    }
    
    @Test
    public void testEditCardList(){
        CardDTO card = new CardDTO();
        card.setCardid(cardid);
        com.nst.domain.List list = new com.nst.domain.List(listid);
        card.setListid(list);
        cardService.editCardList(card);
        verify(cardRepository, times(1)).editCardList(list, card.getCardid());
    }
    
    @Test
    public void testDeleteCard(){
        CardDTO card = new CardDTO();
        card.setCardid(cardid);
        cardService.deleteCard(card);
        verify(cardRepository, times(1)).deleteCard(card.getCardid());
    }
    
    @Test
    public void getAllCards(){
        cardService.getAllCards();
        verify(cardRepository, times(1)).getAllCards();
    }
    
}

