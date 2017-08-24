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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author shifa
 * @since 04-MAR-2014
 */
@Entity
@Table(name = "proj_mst")
@Indexed
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proj_id")
    private Long projectId;

    @Column(name = "actual_end_dt")
    @Temporal(TemporalType.DATE)
    private Date actualEndDate;

    @Column(name = "estmtd_end_dt")
    @Temporal(TemporalType.DATE)
    private Date estimatedEndDate;

    @Column(name = "proj_desc")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    private String projectDescription;

    @Column(name = "proj_nm")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    private String projectName;

    
    @Column(name = "strt_dt")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;

    @Basic(optional = false)
    @Column(name = "is_archive")
    private boolean isArchive;

    @Column(name = "lst_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedOn;

    @Column(name = "proj_alias")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    private String projectAlias;

    @Column(name = "proj_priority")
    private String projectPriority;

//    @Column(name = "proj_mgr")
//    private Long projectManager;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "lst_modified_by")

    private Long lastModifiedBy;

    @OneToMany(mappedBy = "projectId")
    private List<ProjectTechnologyDetail> projectTechnologyDetails;

    @Column(name = "svn_url")
    private String svnUrl;

    public Project() {
    }

    public Project(Long projId) {
        this.projectId = projId;
    }

    public Project(Long projectId, Date actualEndDate, Date estimatedEndDate, String projectDescription, String projectName, Date startDate, Date createdOn, boolean isActive, boolean isArchive, Date lastModifiedOn, String projectAlias, String projectPriority, Long projectManager, Long createdBy, Long lastModifiedBy, List<ProjectTechnologyDetail> projectTechnologyDetails, String svnUrl) {
        this.projectId = projectId;
        this.actualEndDate = actualEndDate;
        this.estimatedEndDate = estimatedEndDate;
        this.projectDescription = projectDescription;
        this.projectName = projectName;
        this.startDate = startDate;
        this.createdOn = createdOn;
        this.isActive = isActive;
        this.isArchive = isArchive;
        this.lastModifiedOn = lastModifiedOn;
        this.projectAlias = projectAlias;
        this.projectPriority = projectPriority;
//        this.projectManager = projectManager;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.projectTechnologyDetails = projectTechnologyDetails;
        this.svnUrl = svnUrl;
    }

    public Project(long l, Date date, Date date0, Boolean TRUE, Boolean FALSE, Object object, Object object0, Object object1, Object object2, Object object3, Object object4, Object object5) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public Long getProjectManager() {
//        return projectManager;
//    }
//
//    public void setProjectManager(Long projectManager) {
//        this.projectManager = projectManager;
//    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public List<ProjectTechnologyDetail> getProjectTechnologyDetails() {
        return projectTechnologyDetails;
    }

    public void setProjectTechnologyDetails(List<ProjectTechnologyDetail> projectTechnologyDetails) {
        this.projectTechnologyDetails = projectTechnologyDetails;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDt) {
        this.actualEndDate = actualEndDt;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public void setEstimatedEndDate(Date estmtdEndDt) {
        this.estimatedEndDate = estmtdEndDt;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsArchive() {
        return isArchive;
    }

    public void setIsArchive(boolean isArchive) {
        this.isArchive = isArchive;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lstModifiedOn) {
        this.lastModifiedOn = lstModifiedOn;
    }

    public String getProjectAlias() {
        return projectAlias;
    }

    public void setProjectAlias(String projAlias) {
        this.projectAlias = projAlias;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projDesc) {
        this.projectDescription = projDesc;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projNm) {
        this.projectName = projNm;
    }

    public String getProjectPriority() {
        return projectPriority;
    }

    public void setProjectPriority(String projPriority) {
        this.projectPriority = projPriority;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date strtDt) {
        this.startDate = strtDt;
    }

    public String getSvnUrl() {
        return svnUrl;
    }

    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.argusoft.armms.model.Project[ projId=" + projectId + " ]";
    }

}
