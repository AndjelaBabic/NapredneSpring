/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service.impl;

import com.nst.dao.BoardDAO;
import com.nst.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andjela Babic
 */
@Service
public class BoardServiceImpl implements BoardService{
    
    @Autowired
    BoardDAO repository; 
}
