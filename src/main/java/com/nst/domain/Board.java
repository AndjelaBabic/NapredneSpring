/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nst.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andjela Babic
 */
@Entity
@Table(name = "board")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Board.findAll", query = "SELECT b FROM Board b")
    , @NamedQuery(name = "Board.findByBoardid", query = "SELECT b FROM Board b WHERE b.boardid = :boardid")
    , @NamedQuery(name = "Board.findByTitle", query = "SELECT b FROM Board b WHERE b.title = :title")
    , @NamedQuery(name = "Board.findByCreated", query = "SELECT b FROM Board b WHERE b.created = :created")
    , @NamedQuery(name = "Board.findByModified", query = "SELECT b FROM Board b WHERE b.modified = :modified")})
public class Board implements Serializable {

    @Size(max = 50)
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "boardid")
    private List<User> userList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "boardid")
    private String boardid;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @OneToMany(mappedBy = "boardid")
    private List<com.nst.domain.List> listList;
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne
    private User userid;

    public Board() {
    }

    public Board(String boardid) {
        this.boardid = boardid;
    }

    public String getBoardid() {
        return boardid;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @XmlTransient
    public List<com.nst.domain.List> getListList() {
        return listList;
    }

    public void setListList(List<com.nst.domain.List> listList) {
        this.listList = listList;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (boardid != null ? boardid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Board)) {
            return false;
        }
        Board other = (Board) object;
        if ((this.boardid == null && other.boardid != null) || (this.boardid != null && !this.boardid.equals(other.boardid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nst.domain.Board[ boardid=" + boardid + " ]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
}
