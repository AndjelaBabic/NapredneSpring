/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service.impl;

import com.nst.dao.CardDAO;
import com.nst.service.CardService;
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
    
}
