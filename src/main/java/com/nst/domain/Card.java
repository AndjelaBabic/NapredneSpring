/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andjela Babic
 */
@Entity
@Table(name = "card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Card.findAll", query = "SELECT c FROM Card c")
    , @NamedQuery(name = "Card.findByCardid", query = "SELECT c FROM Card c WHERE c.cardid = :cardid")
    , @NamedQuery(name = "Card.findByTitle", query = "SELECT c FROM Card c WHERE c.title = :title")
    , @NamedQuery(name = "Card.findByDescription", query = "SELECT c FROM Card c WHERE c.description = :description")
    , @NamedQuery(name = "Card.findByPriority", query = "SELECT c FROM Card c WHERE c.priority = :priority")
    , @NamedQuery(name = "Card.findByDuedate", query = "SELECT c FROM Card c WHERE c.duedate = :duedate")
    , @NamedQuery(name = "Card.findByLabel", query = "SELECT c FROM Card c WHERE c.label = :label")})
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cardid")
    private String cardid;
    @Size(max = 50)
    @Column(name = "title")
    private String title;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @Size(max = 50)
    @Column(name = "priority")
    private String priority;
    @Column(name = "duedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date duedate;
    @Size(max = 50)
    @Column(name = "label")
    private String label;
    @JoinColumn(name = "listid", referencedColumnName = "listid")
    @ManyToOne
    private List listid;

    public Card() {
    }

    public Card(String cardid) {
        this.cardid = cardid;
    }

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

    public List getListid() {
        return listid;
    }

    public void setListid(List listid) {
        this.listid = listid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardid != null ? cardid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Card)) {
            return false;
        }
        Card other = (Card) object;
        if ((this.cardid == null && other.cardid != null) || (this.cardid != null && !this.cardid.equals(other.cardid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nst.domain.Card[ cardid=" + cardid + " ]";
    }
    
}
