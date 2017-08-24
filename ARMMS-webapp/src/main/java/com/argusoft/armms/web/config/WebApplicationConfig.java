/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.argusoft.armms.web.config;

import com.argusoft.generic.core.config.CoreApplicationConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Configuration file for web
 * @author ravi
 */
@Configuration
@Import({CoreApplicationConfig.class})
@ComponentScan(basePackages = {"com.argusoft"})
@ImportResource("/WEB-INF/armms_security.xml")
@EnableScheduling
public class WebApplicationConfig {
}