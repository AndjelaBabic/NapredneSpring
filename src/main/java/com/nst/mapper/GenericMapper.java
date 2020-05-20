/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.mapper;

import com.nst.domain.User;
import com.nst.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GenericMapper {

    GenericMapper INSTANCE = Mappers.getMapper(GenericMapper.class);
    
    UserDTO userToUserDTO(User User);

}
