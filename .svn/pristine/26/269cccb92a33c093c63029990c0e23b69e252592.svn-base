/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * Model for storing basic details of revision
 *
 * @author ravi
 */
@Entity
@Table(name = "svn_details")
@Indexed
public class SvnDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "rev_no")
    private Long revisionNo;
    @Column(name = "comment")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    @Type(type = "org.hibernate.type.StringClobType")
    private String comment;
    @Column(name = "commited_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commitedOn;
    @Column(name = "commiter")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    private String commiter;
    @Column(name = "proj_id")
    private Long projectId;
    @Column(name = "tsk_id")
    private String taskId;
    @OneToMany(mappedBy = "svnDetail")
    @Cascade(value = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DELETE, CascadeType.SAVE_UPDATE})
    private List<SvnFileDetails> svnFileDetails;

    public SvnDetail() {
    }

    public SvnDetail(Long revisionNo) {
        this.revisionNo = revisionNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommitedOn() {
        return commitedOn;
    }

    public void setCommitedOn(Date commitedOn) {
        this.commitedOn = commitedOn;
    }

    public String getCommiter() {
        return commiter;
    }

    public void setCommiter(String commiter) {
        this.commiter = commiter;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getRevisionNo() {
        return revisionNo;
    }

    public void setRevisionNo(Long revisionNo) {
        this.revisionNo = revisionNo;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public List<SvnFileDetails> getSvnFileDetails() {
        return svnFileDetails;
    }

    public void setSvnFileDetails(List<SvnFileDetails> svnFileDetails) {
        this.svnFileDetails = svnFileDetails;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final SvnDetail other = (SvnDetail) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SvnDetail{" + "id=" + id + ", revisionNo=" + revisionNo + '}';
    }

}
