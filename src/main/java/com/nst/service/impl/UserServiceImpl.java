/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service.impl;

import com.nst.dao.UserDAO;
import com.nst.domain.User;
import com.nst.dto.UserDTO;
import com.nst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andjela Babic
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO repository;

    @Override
    public User authenticate(UserDTO user) {
       return repository.login(user.getEmail(), user.getPassword());
    }

    @Override
    public void insertUser(UserDTO user) {
        // TODO Check if user with that email exists 
        repository.insertUser(user.getFullname(), user.getEmail(), user.getPassword());
    }

}
