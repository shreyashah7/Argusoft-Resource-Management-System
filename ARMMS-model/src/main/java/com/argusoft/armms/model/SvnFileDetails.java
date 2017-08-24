/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 * Model for storing file details of a revision
 * @author ravi
 */
@Entity
@Table(name = "svn_file_details")
public class SvnFileDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @JoinColumn(name = "svnDetail_id", referencedColumnName = "id")
    @ManyToOne
    private SvnDetail svnDetail;
    @Column(name = "file_path")
    @Type(type = "org.hibernate.type.StringClobType")
    private String filePath;
    @Column(name = "change_type")
    private String changeType;
    @Column(name = "path_type")
    private String pathType;   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    
    
    public SvnDetail getSvnDetail() {
        return svnDetail;
    }

    public void setSvnDetail(SvnDetail svnDetail) {
        this.svnDetail = svnDetail;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getPathType() {
        return pathType;
    }

    public void setPathType(String pathType) {
        this.pathType = pathType;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SvnFileDetails other = (SvnFileDetails) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SvnFileDetails{" + "id=" + id + ", revisionNo=" + svnDetail + ", filePath=" + filePath + '}';
    }

}
