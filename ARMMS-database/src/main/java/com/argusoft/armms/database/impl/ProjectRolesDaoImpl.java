/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database.impl;

import com.argusoft.armms.database.ProjectRolesDao;
import com.argusoft.armms.model.ProjectRoles;
import com.argusoft.generic.database.common.impl.BaseAbstractGenericDao;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shreya
 */
@Repository
public class ProjectRolesDaoImpl extends BaseAbstractGenericDao<ProjectRoles, Long> implements ProjectRolesDao {

    public final static String ISACTIVE = "isActive";
    
    @Override
    public List<ProjectRoles> retrieveAllRolesOfProject(Boolean status) {
        List<ProjectRoles> projectRolesList;
        List<Criterion> criterions = new LinkedList<Criterion>();
        if (status != null) {
            criterions.add(Restrictions.eq(ISACTIVE, status));
        }
        projectRolesList = super.findByCriteriaList(criterions);
        return projectRolesList;
    }

}
