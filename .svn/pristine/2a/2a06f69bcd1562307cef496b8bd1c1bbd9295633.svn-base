/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database.impl;

import com.argusoft.armms.database.UserSkillsDao;
import static com.argusoft.armms.database.impl.TaskMasterDaoImpl.ASSIGNED_TO;
import com.argusoft.armms.model.TaskMaster;
import com.argusoft.armms.model.TechnologyMaster;
import com.argusoft.armms.model.UserSkillSet;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Dao Implementation for UserSkills
 *
 * @author shifa
 */
@Repository
public class UserSkillsDaoImpl extends BaseAbstractGenericDao<UserSkillSet, Long> implements UserSkillsDao {

    @Override
    public List<UserSkillSet> getAllUserSkills(Boolean active) {
        List<UserSkillSet> userskill;
        List<Criterion> criterions = new LinkedList<Criterion>();
        if (active != null) {
            criterions.add(Restrictions.eq("isActive", active));
        }

        userskill = super.findByCriteriaList(criterions);
        return userskill;

    }

    @Override
    public List<UserSkillSet> getAllUserSkillsByUserId(long userId) {
        List<UserSkillSet> alluserskills;
        List<Criterion> criterions = new LinkedList<Criterion>();

        criterions.add(Restrictions.eq(" userId", userId));

        alluserskills = super.findByCriteriaList(criterions);
        return alluserskills;
    }

    @Override
    public List<UserSkillSet> getAllUsersByUserSkillId(long userSkillSetId) {
        List<UserSkillSet> alluser;
        List<Criterion> criterions = new LinkedList<Criterion>();

        criterions.add(Restrictions.eq(" userSkillSetId", userSkillSetId));

        alluser = super.findByCriteriaList(criterions);
        return alluser;
    }

    @Override
    public List<UserSkillSet> retrieveSkillsOfUsersForProject(List<Long> userIds, List<Long> techIds) {
        List<UserSkillSet> skillsOfUsersForProject;
        List<Criterion> criterions = new LinkedList<Criterion>();
        if (userIds != null && techIds.size()>0) {
            criterions.add(Restrictions.in("userId", userIds));
        }

        if (techIds != null && techIds.size()>0) {
            criterions.add(Restrictions.in("technologyId.technologyId", techIds));
        }

        skillsOfUsersForProject = super.findByCriteriaList(criterions);
        
        if(skillsOfUsersForProject==null){
            skillsOfUsersForProject = new ArrayList<UserSkillSet>();
        }
        
        return skillsOfUsersForProject;
    }

}
