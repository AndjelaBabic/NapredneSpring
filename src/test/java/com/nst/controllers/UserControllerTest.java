/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.controllers;

/**
 *
 * @author USER
 */
import com.nst.client.controller.UserController;
import com.nst.dto.UserDTO;
import com.nst.service.UserService;
import javax.validation.constraints.AssertTrue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.springframework.http.HttpStatus;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    
    public final String EMAIL = "some@gmail.com"; 
    public final String PASS = "password123"; 
    public final String FULL_NAME = "Andjela Babic"; 
    public final int ID = 1; 
    
    @InjectMocks // real object of the class to test out 
    UserController userController; 
    
    @Mock// fake class where all fiedls are null, behavior is determined 
    UserService userService; 
    
    @Test
    public void testLogin(){
        UserDTO userdto = new UserDTO();
        userdto.setEmail(EMAIL);
        userdto.setPassword(PASS);
        UserDTO result = new UserDTO();
        result.setEmail(EMAIL);
        result.setPassword(PASS);
        result.setId(ID);
        result.setFullname(FULL_NAME);
        when(userService.authenticate(userdto)).thenReturn(result);
        ResponseEntity response = (ResponseEntity) userController.login(userdto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(result, response.getBody());
    }
    
    @Test
    public void testRegistrationSuccesfull(){
        UserDTO userdto = new UserDTO();
        userdto.setEmail(EMAIL);
        userdto.setPassword(PASS);
        userdto.setFullname(FULL_NAME);
        ResponseEntity response = (ResponseEntity) userController.signup(userdto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
