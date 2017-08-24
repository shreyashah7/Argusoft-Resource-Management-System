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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shreya
 */
@Entity
@Table(name = "tsk_dpndncy")
@XmlRootElement

public class TaskDependency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tsk_dpndncy_id")
    private Long taskDependencyId;
    
    @Column(name = "dpnded_on")
    private Long dependedOn;
    
    @Column(name = "dpndncy_type")
    private String dependencyType;
    
    // column(name= task_id) from task master
    @JoinColumn(name = "tsk_id", referencedColumnName = "tsk_id", nullable = false)
    @ManyToOne(optional = false)
    private TaskMaster task_id;

    public TaskDependency() {
    }

    public TaskDependency(Long taskDependencyId) {
        this.taskDependencyId = taskDependencyId;
    }

    public Long getTaskDependencyId() {
        return taskDependencyId;
    }

    public void setTaskDependencyId(Long taskDependencyId) {
        this.taskDependencyId = taskDependencyId;
    }

    public Long getDependedOn() {
        return dependedOn;
    }

    public void setDependedOn(Long dependedOn) {
        this.dependedOn = dependedOn;
    }

    public TaskMaster getTask_id() {
        return task_id;
    }

    public void setTask_id(TaskMaster task_id) {
        this.task_id = task_id;
    }


    public String getDependencyType() {
        return dependencyType;
    }

    public void setDependencyType(String dependencyType) {
        this.dependencyType = dependencyType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskDependencyId != null ? taskDependencyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskDependency)) {
            return false;
        }
        TaskDependency other = (TaskDependency) object;
        if ((this.taskDependencyId == null && other.taskDependencyId != null) || (this.taskDependencyId != null && !this.taskDependencyId.equals(other.taskDependencyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.argusoft.armms.model.TaskDependency[ tskDpndncyId=" + taskDependencyId + " ]";
    }
    
}
