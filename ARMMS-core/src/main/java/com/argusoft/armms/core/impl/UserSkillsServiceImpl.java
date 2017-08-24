/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core.impl;

import com.argusoft.armms.database.TechnologyDao;
import com.argusoft.armms.database.UserSkillsDao;
import com.argusoft.armms.core.UserSkillsService;
import com.argusoft.armms.database.UserSkillExperienceDao;
import com.argusoft.armms.model.TechnologyMaster;
import com.argusoft.armms.model.UserSkillExperience;
import com.argusoft.armms.model.UserSkillSet;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for UserSkillService
 *
 * @author shifa
 */
@Service("userSkillsService")
@Transactional
public class UserSkillsServiceImpl implements UserSkillsService {

    @Autowired
    private UserSkillsDao userSkillsDao;
    @Autowired
    private TechnologyDao techDao;
    @Autowired
    UserSkillExperienceDao userSkillExpDao;

    public UserSkillsDao getUserSkillsDao() {
        return userSkillsDao;
    }

    public void setUserSkillsDao(UserSkillsDao userSkillsDao) {
        this.userSkillsDao = userSkillsDao;
    }

    public TechnologyDao getTechDao() {
        return techDao;
    }

    public void setTechDao(TechnologyDao techDao) {
        this.techDao = techDao;
    }

    public UserSkillExperienceDao getUserSkillExpDao() {
        return userSkillExpDao;
    }

    public void setUserSkillExpDao(UserSkillExperienceDao userSkillExpDao) {
        this.userSkillExpDao = userSkillExpDao;
    }

    @Override
    public long createTechnology(TechnologyMaster techmaster) {

        techmaster.setIsArchive(false);

        if (techmaster.getCreatedOn() == null) {
            techmaster.setCreatedOn(Calendar.getInstance().getTime());
        }

        techmaster.setLastModifiedOn(Calendar.getInstance().getTime());
        Long technologyId = techDao.create(techmaster);
        return technologyId;
    }

    @Override
    public Long createUserSkill(UserSkillSet userskillset) {
        Date currentTime = Calendar.getInstance().getTime();

        if (userskillset.getCreatedOn() == null) {
            userskillset.setCreatedOn(currentTime);
        }

        userskillset.setLastModifiedOn(currentTime);
        Long userSkillId = userSkillsDao.create(userskillset);
        return userSkillId;

    }

    @Override
    public void updateUserSkill(UserSkillSet userskillset) {
        userskillset.setCreatedOn(Calendar.getInstance().getTime());
        userSkillsDao.update(userskillset);
    }

    @Override
    public List<UserSkillSet> getAllUserSkills(Boolean isActive) {
        return userSkillsDao.getAllUserSkills(isActive);
    }

    @Override
    public List<UserSkillSet> getSkillByUserId(long userId) {
        return userSkillsDao.getAllUserSkillsByUserId(userId);
    }

    @Override
    public List<UserSkillSet> getUserBySkillSetId(long userSkillSetId) {
        return userSkillsDao.getAllUsersByUserSkillId(userSkillSetId);
    }

    @Override
    public long createUserSkillExperience(UserSkillExperience userskillexp) {
        Long userSkillExpId = userSkillExpDao.create(userskillexp);
        return userSkillExpId;
    }

    @Override
    public void updateUserSkillExperience(UserSkillExperience userskillexp) {
        userskillexp.setCreatedOn(Calendar.getInstance().getTime());
        userSkillExpDao.update(userskillexp);
    }

    @Override
    public List<TechnologyMaster> retrieveTechnologies(Boolean isActive) {
        return techDao.retrieveAllTechnologies(isActive);

    }

    @Override
    public TechnologyMaster retrieveTechnologyById(Long id) {

        return techDao.retrieveById(id);

    }

    @Override
    public void updateTechnology(TechnologyMaster technologyMaster) {

        techDao.update(technologyMaster);
    }

    @Override
    public List<TechnologyMaster> retrieveTechnologiesByTechnologylist(List<Long> techIDs) {
        return techDao.retrieveTechnologiesByTechnologyList(techIDs);
    }

    @Override
    public List<UserSkillSet> retrieveSkillsOfUsersForProject(List<Long> userIds, List<Long> techIds) {
        return userSkillsDao.retrieveSkillsOfUsersForProject(userIds, techIds);
    }

    @Override
    public List<TechnologyMaster> retrieveTechnologiesByTechnologyListAndTechnologyType(List<Long> techIDs, String technologytype) {
        return techDao.retrieveTechnologiesByTechnologyListAndTechnologyType(techIDs, technologytype);

    }

    @Override
    public List<TechnologyMaster> retrieveAllActiveTechnologiesByTechnologyType(String technologyType) {
        return techDao.retrieveAllActiveTechnologiesByTechnologyType(technologyType);

    }

    @Override
    public List<TechnologyMaster> retrieveTechnologyByTechnologyName(String technologyName) {
        return techDao.retrieveTechnologiesByTechnologyName(technologyName);

    }

}
