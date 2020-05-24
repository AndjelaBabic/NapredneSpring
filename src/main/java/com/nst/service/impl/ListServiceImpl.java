/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service.impl;

import com.nst.dao.ListDAO;
import com.nst.domain.Board;
import com.nst.domain.Card;
import com.nst.dto.CardDTO;
import com.nst.dto.ListDTO;
import com.nst.service.ListService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andjela Babic
 */
@Service
public class ListServiceImpl implements ListService{
    
    @Autowired
    ListDAO repository; 

    @Override
    public List<ListDTO> getAllLists() {
        List<com.nst.domain.List> result = repository.findAll();
        List<ListDTO> returnList = new ArrayList<>();
        for (com.nst.domain.List list : result) {
            ListDTO newList = new ListDTO(); 
            newList.setListid(list.getListid());
            newList.setTitle(list.getTitle());
            newList.setBoardid(list.getBoardid().getBoardid());
            String[] cardIds = new String[list.getCardList().size()];
            int i = 0; 
            for (Card card : list.getCardList()) {
                cardIds[i] = card.getCardid();
                i++; 
            }
            newList.setCardids(cardIds);
            returnList.add(newList);
        }
        return returnList; 
    }

    @Override
    public void addList(ListDTO list) {
        repository.addList(list.getListid(), list.getTitle(), list.getBoardid());
    }

    @Override
    public void editListTitle(ListDTO list) {
        repository.editListTitle(list.getTitle(), list.getListid());
    }

    @Override
    public void deleteList(ListDTO list) {
        repository.deleteList(list.getListid());
    }
}
