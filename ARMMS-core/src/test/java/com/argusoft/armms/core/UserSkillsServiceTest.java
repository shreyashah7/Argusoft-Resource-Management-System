/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.core;

import com.argusoft.armms.model.TechnologyMaster;
import com.argusoft.armms.model.UserSkillExperience;
import com.argusoft.armms.model.UserSkillSet;
import com.argusoft.generic.core.config.CoreApplicationConfig;
import java.util.Calendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author brijesh
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {CoreApplicationConfig.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserSkillsServiceTest {

    @Autowired
    @Qualifier("userSkillsService")
    UserSkillsService userSkillsService;

    public UserSkillsServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createTechnology method, of class UserSkillsService.
     */
    @Test
    public void testCreateTechnology() {
        System.out.println("+++++++++++++++createTechnology++++++++++++++++++");
        TechnologyMaster technologyMaster = new TechnologyMaster();
        technologyMaster.setTechType("T");
        technologyMaster.setIsActive(Boolean.TRUE);
        technologyMaster.setTechnologyName("jsf");
        technologyMaster.setTechnologyDesc("jsf");
        technologyMaster.setLastModifiedBy((long) 1);
        technologyMaster.setCreatedBy(1L);

        userSkillsService.createTechnology(technologyMaster);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveTechnologies method, of class UserSkillsService.
     */
    @Test
    public void testRetrieveTechnologies() {
        System.out.println("+++++++++++retrieveTechnologies+++++++++++");
        List<TechnologyMaster> technologyMasterslist = userSkillsService.retrieveTechnologies(null);
        for (TechnologyMaster master : technologyMasterslist) {
            System.out.println("Technology name:::::" + master.getTechnologyName());
            System.out.println("Technology type:::::" + master.getTechType());
            System.out.println("--------------------------------------------------------");
            System.out.println("\n");

        }

        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getTechnologyById method, of class UserSkillsService.
     */
    @Test
    public void testGetTechnologyById() {
        System.out.println("\n");
        System.out.println("+++++++++++++getTechnologyById++++++++++++++");
        List<TechnologyMaster> masterList = userSkillsService.retrieveTechnologies(Boolean.TRUE);
        if (masterList != null && !masterList.isEmpty()) {
            Long id = masterList.get(0).getTechnologyId();
            TechnologyMaster master = userSkillsService.retrieveTechnologyById(id);
            System.out.println("Technology name:::::" + master.getTechnologyName());
            System.out.println("Technology type:::::" + master.getTechType());
            System.out.println("--------------------------------------------------------");
            System.out.println("\n");

        }
    }

    /**
     * Test of updateTechnology method, of class UserSkillsService.
     */
    @Test
    public void testUpdateTechnology() {
        System.out.println("\n");
        System.out.println("+++++++++++updateTechnology++++++++++++++");

        List<TechnologyMaster> masterList = userSkillsService.retrieveTechnologies(Boolean.TRUE);
        if (masterList != null && !masterList.isEmpty()) {

            Long id = masterList.get(0).getTechnologyId();

            TechnologyMaster master = userSkillsService.retrieveTechnologyById(id);

            System.out.println("Last Modify On::::" + master.getLastModifiedOn());
            master.setLastModifiedOn(Calendar.getInstance().getTime());

            userSkillsService.updateTechnology(master);
            master = userSkillsService.retrieveTechnologyById(id);
            System.out.println("Last Modify On after Modification::::" + master.getLastModifiedOn());

        }
    }

}
//}
