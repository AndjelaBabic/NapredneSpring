/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service.impl;

import com.nst.dao.CardDAO;
import com.nst.domain.Card;
import com.nst.dto.CardDTO;
import com.nst.mapper.GenericMapper;
import com.nst.service.CardService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Andjela Babic
 */
@Service
public class CardServiceImpl implements CardService{
    
    @Autowired
    CardDAO repository; 

    @Override
    public void addCard(CardDTO card) {
        repository.addCard(card.getCardid(), card.getTitle(), card.getDescription(), card.getPriority(),
                card.getDuedate(), card.getLabel(), card.getListid());
    }

    @Override
    public void editCardTitle(CardDTO card) {
        repository.editCardTitle(card.getTitle(), card.getCardid());
    }

    @Override
    public void editCardList(CardDTO card) {
        com.nst.domain.List list = new com.nst.domain.List(card.getListid()); 
        repository.editCardList(list, card.getCardid());
    }

    @Override
    public void deleteCard(CardDTO card) {
        repository.deleteCard(card.getCardid());
    }

    @Override
    public java.util.List<CardDTO> getAllCards() {
        List<Card> result = repository.getAllCards();
        List<CardDTO> cards = new ArrayList<>();
        for (Card card : result) {
            CardDTO cardDTO = new CardDTO(); 
            cardDTO.setCardid(card.getCardid());
            cardDTO.setTitle(card.getTitle());
            cardDTO.setListid(card.getListid());
            cards.add(cardDTO);
        }
        return cards; 
    }
}
