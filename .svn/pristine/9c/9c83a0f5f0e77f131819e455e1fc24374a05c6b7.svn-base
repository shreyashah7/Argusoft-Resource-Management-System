/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author shreya
 */
@Embeddable
public class TaskTechnologyDetailPK implements Serializable {
    
    // column(name = "task_id) from task master
    @JoinColumn(name = "tsk_id", referencedColumnName = "tsk_id")
    @ManyToOne(optional = false)
    private TaskMaster task_mstr;
    
    //column(name = "tech_id") from tech master
    @JoinColumn(name = "tech_id", referencedColumnName = "tech_id")
    @ManyToOne(optional = false)
    private TechnologyMaster tech_mst;
    
    public TaskTechnologyDetailPK() {
    }

    public TaskTechnologyDetailPK(TaskMaster task_mstr, TechnologyMaster tech_mst) {
        this.task_mstr = task_mstr;
        this.tech_mst = tech_mst;
    }

    public TaskMaster getTask_mstr() {
        return task_mstr;
    }

    public void setTask_mstr(TaskMaster task_mstr) {
        this.task_mstr = task_mstr;
    }

    public TechnologyMaster getTech_mst() {
        return tech_mst;
    }

    public void setTech_mst(TechnologyMaster tech_mst) {
        this.tech_mst = tech_mst;
    }

    @Override
    public String toString() {
        return "TaskTechnologyDetailPK{" + "task_mstr=" + task_mstr + ", tech_mst=" + tech_mst + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.task_mstr != null ? this.task_mstr.hashCode() : 0);
        hash = 83 * hash + (this.tech_mst != null ? this.tech_mst.hashCode() : 0);
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
        final TaskTechnologyDetailPK other = (TaskTechnologyDetailPK) obj;
        if (this.task_mstr != other.task_mstr && (this.task_mstr == null || !this.task_mstr.equals(other.task_mstr))) {
            return false;
        }
        if (this.tech_mst != other.tech_mst && (this.tech_mst == null || !this.tech_mst.equals(other.tech_mst))) {
            return false;
        }
        return true;
    }

}
