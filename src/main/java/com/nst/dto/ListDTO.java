/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.dto;

import com.nst.domain.Board;
import com.nst.domain.Card;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author Andjela Babic
 */
public class ListDTO {
    
    private String listid;
    private String title;
    private String boardid;
    private String[] cardids; 

    public String getListid() {
        return listid;
    }

    public void setListid(String listid) {
        this.listid = listid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBoardid() {
        return boardid;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public String[] getCardids() {
        return cardids;
    }

    public void setCardids(String[] cardids) {
        this.cardids = cardids;
    }

    
    @Override
    public String toString() {
        return "ListDTO{" + "listid=" + listid + ", title=" + title + ", boardid=" + boardid + '}';
    }
    
    
}
