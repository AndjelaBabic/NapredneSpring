/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service;

import com.nst.domain.List;
import com.nst.dto.BoardDTO;
import com.nst.dto.ListDTO;

/**
 *
 * @author Andjela Babic
 */
public interface ListService {
 
    public java.util.List<List> getAllListsForTheBoard(String boardid);
    public void addList(ListDTO list);
    public void editListTitle(ListDTO list); 
}
