/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core;

import com.argusoft.armms.model.TechnologyMaster;
import com.argusoft.armms.model.UserSkillExperience;
import com.argusoft.armms.model.UserSkillSet;
import java.util.List;

/**
 * Service interface for UserSkillService
 *
 * @author shifa
 */
public interface UserSkillsService {

    /**
     * createTechnology method creates TechnologyMaster object
     *
     * @param techmaster Takes in the TechnologyMaster object that has to be
     * created
     * @return id of TechnologyMaster
     */
    public long createTechnology(TechnologyMaster techmaster);

    /**
     * getAllTechnologies method retrieves List of all objects of
     * TechnologyMaster
     *
     *
     * @param isActive checks for all the technologies which are active
     * @return List of object of TechnologyMaster
     */
    public List<TechnologyMaster> retrieveTechnologies(Boolean isActive);

    /**
     * @author niharika getAllTechnologies method retrieves List of all objects
     * of TechnologyMaster by list of id
     *
     *
     * @param techIDs
     * @return List of object of TechnologyMaster
     */
    public List<TechnologyMaster> retrieveTechnologiesByTechnologylist(List<Long> techIDs);

    /**
     *
     * @param id
     * @return
     */
    public TechnologyMaster retrieveTechnologyById(Long id);

    /**
     *
     * @param technologyMaster
     */
    public void updateTechnology(TechnologyMaster technologyMaster);

    /**
     * createUserSkill method creates UserSkillSet object
     *
     * @param userskillset Takes in the UserSkillSet object that has to be
     * created
     * @return id of UserSkillSet
     */
    public Long createUserSkill(UserSkillSet userskillset);

    /**
     * updateUserSkill method updates UserSkillSet object
     *
     * @param userskillset Takes in the object of UserSkillSet that has to be
     * updated
     */
    public void updateUserSkill(UserSkillSet userskillset);

    /**
     * getAllUserSkills method retrieves List of all object of UserSkillSet
     *
     * @param isActive checks for all the skills which are active
     * @return List of object of UserSkillSet
     */
    public List<UserSkillSet> getAllUserSkills(Boolean isActive);

    /**
     * getSkillByUserId method retrieves UserSkillSet object by specified userId
     *
     * @param userId takes the user_id of UserSkillSet
     * @return UserSkillSet object
     *
     */
    public List<UserSkillSet> getSkillByUserId(long userId);

    /**
     * getUserBySkillSetId method retrieves UserSkillSet object by specified
     * userSkillSetId
     *
     * @param userSkillSetId takes the skill id of UserSkillSet
     * @return UserSkillSet object
     *
     */
    public List<UserSkillSet> getUserBySkillSetId(long userSkillSetId);

    /**
     * createUserSkillExperience method creates UserSkillExperience object
     *
     * @param userskillexp Takes in the UserSkillExperience object that has to
     * be created
     * @return id of UserSkillExperience
     */
    public long createUserSkillExperience(UserSkillExperience userskillexp);

    /**
     * updateUserSkillExperience method updates UserSkillEperience object
     *
     * @param userskillexp Takes in the object of UserSkillExperience that has
     * to be updated
     */
    public void updateUserSkillExperience(UserSkillExperience userskillexp);

    public List<UserSkillSet> retrieveSkillsOfUsersForProject(List<Long> userIds, List<Long> techIds);

    /**
     *
     * @param techIDs
     * @param technologytype
     * @return
     */
    public List<TechnologyMaster> retrieveTechnologiesByTechnologyListAndTechnologyType(List<Long> techIDs, String technologytype);

    /**
     *
     * @param isActive
     * @param technologyType
     * @return
     */
    public List<TechnologyMaster> retrieveAllActiveTechnologiesByTechnologyType(String technologyType);

    public List<TechnologyMaster> retrieveTechnologyByTechnologyName(String technologyName);
}
