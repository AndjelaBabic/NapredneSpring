/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andjela Babic
 */
@Entity
@Table(name = "list")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "List.findAll", query = "SELECT l FROM List l")
    , @NamedQuery(name = "List.findByListid", query = "SELECT l FROM List l WHERE l.listid = :listid")
    , @NamedQuery(name = "List.findByTitle", query = "SELECT l FROM List l WHERE l.title = :title")})
public class List implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "listid")
    private String listid;
    @Size(max = 50)
    @Column(name = "title")
    private String title;
    @JoinColumn(name = "boardid", referencedColumnName = "boardid")
    @ManyToOne
    @JsonIgnore
    private Board boardid;
    @OneToMany(mappedBy = "listid")
    private java.util.List<Card> cardList;

    public List() {
    }

    public List(String listid) {
        this.listid = listid;
    }

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

    public Board getBoardid() {
        return boardid;
    }

    public void setBoardid(Board boardid) {
        this.boardid = boardid;
    }

    @XmlTransient
    public java.util.List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(java.util.List<Card> cardList) {
        this.cardList = cardList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listid != null ? listid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof List)) {
            return false;
        }
        List other = (List) object;
        if ((this.listid == null && other.listid != null) || (this.listid != null && !this.listid.equals(other.listid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nst.domain.List[ listid=" + listid + " ]";
    }
    
}
