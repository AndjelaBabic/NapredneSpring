/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.dto;

import com.nst.domain.List;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Andjela Babic
 */
public class CardDTO {
    
    private String cardid;
    private String title;
    private String description;
    private String priority;
    private Date duedate;
    private String label;
    private String listid;

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getListid() {
        return listid;
    }

    public void setListid(List list) {
        this.listid = list.getListid();
    }
    
    
    @Override
    public String toString() {
        return "CardDTO{" + "cardid=" + cardid + ", title=" + title + ", description=" + description + ", priority=" + priority + ", duedate=" + duedate + ", label=" + label + ", listid=" + listid + '}';
    }
    
}
