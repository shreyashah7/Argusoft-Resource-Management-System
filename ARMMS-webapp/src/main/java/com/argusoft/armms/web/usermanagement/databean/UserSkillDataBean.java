/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.web.usermanagement.databean;

/**
 *
 * @author ravi
 */
public class UserSkillDataBean {
    Long techid;
    String techname;
    Double experience;    

    public UserSkillDataBean() {
    }

    public UserSkillDataBean(Long techid, Double experience) {
        this.techid = techid;
        this.experience = experience;
    }

    public Long getTechid() {
        return techid;
    }

    public void setTechid(Long techid) {
        this.techid = techid;
    }

    public String getTechname() {
        return techname;
    }

    public void setTechname(String techname) {
        this.techname = techname;
    }
    
    public Double getExperience() {
        return experience;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
    }
    
    @Override
    public String toString() {
        return "UserSkillDataBean{" + "techid=" + techid + ", experience=" + experience + '}';
    }
}
