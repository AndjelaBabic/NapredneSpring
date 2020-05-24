/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.client.controller;

import com.nst.domain.User;
import com.nst.dto.CardDTO;
import com.nst.dto.ListDTO;
import com.nst.dto.UserDTO;
import com.nst.payload.ApiResponse;
import com.nst.service.ListService;
import com.nst.service.UserService;
import com.nst.util.Messages;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andjela Babic
 */
@RestController
@CrossOrigin
public class ListController {

    @Autowired
    private ListService service;

    @RequestMapping(value = "/getlists", method = RequestMethod.GET)
    public @ResponseBody
    Object getListsForTheBoard() {
        List<ListDTO> lists = service.getAllLists();
        return ResponseEntity.status(HttpStatus.OK).body(lists);
    }

    @RequestMapping(value = "/addList", method = RequestMethod.POST)
    public @ResponseBody
    Object addList(@RequestBody ListDTO list) {
        try {
            service.addList(list);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true, "List " + Messages.SUCCESS_INSERT));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, Messages.ERROR_INSERT + " list"));
        }
    }

    @RequestMapping(value = "/editListTitle", method = RequestMethod.PUT)
    public @ResponseBody
    Object editListTitle(@RequestBody ListDTO list) {
        try {
            System.out.println(list);
            service.editListTitle(list);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse((true), Messages.SUCCESS_UPDATE + " list"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, Messages.ERROR_UPDATE + " list"));
        }
    }

    @RequestMapping(value = "/deleteList", method = RequestMethod.DELETE)
    public @ResponseBody
    Object deleteList(@RequestBody ListDTO list) {
        try {
            service.deleteList(list);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse((true), Messages.SUCCESS_DELETE + " list"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse((false), Messages.ERROR_DELETE + " list"));
        }
    }

}
