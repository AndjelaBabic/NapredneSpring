/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service;

import com.nst.domain.Card;
import com.nst.dto.BoardDTO;
import com.nst.dto.CardDTO;
import java.util.List;

/**
 *
 * @author Andjela Babic
 */
public interface CardService {
    
    public void addCard(CardDTO card);
    
    public void editCardTitle(CardDTO card); 
    
    public void editCardList(CardDTO card);
    
    public void deleteCard(CardDTO card); 
    
    public List<CardDTO> getAllCards(); 
}
