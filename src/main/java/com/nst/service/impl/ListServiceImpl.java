/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service.impl;

import com.nst.dao.ListDAO;
import com.nst.domain.Board;
import com.nst.dto.ListDTO;
import com.nst.service.ListService;
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
    public List<com.nst.domain.List> getAllListsForTheBoard(String boardid) {
        Board board = new Board(boardid);
        return repository.getAllListsForTheBoard(board);
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
