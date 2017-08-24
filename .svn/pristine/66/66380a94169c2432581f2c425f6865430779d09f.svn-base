/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.database;

import com.argusoft.armms.model.UserSkillSet;
import com.argusoft.generic.database.common.GenericDao;
import java.util.List;

/**
 *Dao Interface for UserSkills (master Table)
 * @author shifa
 */
public interface UserSkillsDao extends GenericDao<UserSkillSet, Long> {
 
    public List<UserSkillSet> getAllUserSkills(Boolean active);

    public List<UserSkillSet> getAllUserSkillsByUserId(long userId);

    public List<UserSkillSet> getAllUsersByUserSkillId(long userSkillSetId);

    public List<UserSkillSet> retrieveSkillsOfUsersForProject(List<Long> userIds, List<Long> techIds);

}
