/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.mapper;

/**
 *
 * @author USER
 */
import com.nst.domain.User;
import com.nst.dto.UserDTO;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    
    public static final Integer ID = 1;
    public static final String FULL_NAME = "Andjela Babic";
    public static final String EMAIL = "andjelasbabic@gmail.com";
    public static final String PASSWORD = "pass123";

    @Autowired
    GenericMapper mapper; 
    
    @Before
    public void setUp() {

    }
    
    @Test
    public void mappingUserToUserDTO(){
        User user = new User(); 
        user.setId(ID);
        user.setEmail(EMAIL);
        user.setPassword(PASSWORD);
        user.setFullname(FULL_NAME);
        
        UserDTO userDto = mapper.userToUserDTO(user);
        
        assertEquals(user.getId(), userDto.getId());
        assertEquals(user.getFullname(), userDto.getFullname());
        assertEquals(user.getEmail(), userDto.getEmail());
        assertEquals(user.getPassword(), userDto.getPassword());
    }
    
    @Test
    public void mappingUserDTOtoUser(){
        UserDTO userDTO = new UserDTO(); 
        userDTO.setId(ID);
        userDTO.setEmail(EMAIL);
        userDTO.setPassword(PASSWORD);
        userDTO.setFullname(FULL_NAME);
        
        User user = mapper.userDTOtoUser(userDTO);
        
        assertEquals(userDTO.getId(), user.getId());
        assertEquals(userDTO.getFullname(), user.getFullname());
        assertEquals(userDTO.getEmail(), user.getEmail());
        assertEquals(userDTO.getPassword(), user.getPassword());
    }

}
