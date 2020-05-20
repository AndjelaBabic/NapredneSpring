/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.client.controller;

import com.nst.domain.User;
import com.nst.dto.UserDTO;
import com.nst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Andjela Babic
 */
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Object login(@RequestBody UserDTO userDto) {
        UserDTO user = userService.authenticate(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public @ResponseBody Object signup(@RequestBody UserDTO userDto) {
         try {
            userService.insertUser(userDto);
            return ResponseEntity.status(HttpStatus.OK).body("User sucessfully inserted ");
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while inserting User");
        }
        
    }

}
