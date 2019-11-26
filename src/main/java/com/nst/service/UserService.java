/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.service;

import com.nst.domain.User;
import com.nst.dto.UserDTO;
import org.hibernate.MappingException;

/**
 *
 * @author Andjela Babic
 */
public interface UserService {

    User authenticate(UserDTO user);

}
