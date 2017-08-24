/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.security;

import com.argusoft.usermanagement.common.core.UMUserService;
import com.argusoft.usermanagement.common.model.UMUser;
import com.argusoft.usermanagement.common.model.UMUserRole;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;

/**
 * This class is for authorization i.e after login it provides the authorities
 * associated with logged in user
 *
 * @author shifa
 */
public class ArmmsSecurityUserService implements UserDetailsService {

    @Autowired
    private UMUserService umUserService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UMUser uMUser = umUserService.getUserbyUserName(userName, false, true, false, false, false, Boolean.TRUE);
        if (uMUser == null) {
            throw new UsernameNotFoundException("Invalid username/password.");
        }

        Set<UMUserRole> roles = uMUser.getUMUserRoleSet();
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (!CollectionUtils.isEmpty(roles)) {
            for (Iterator<UMUserRole> it = roles.iterator(); it.hasNext();) {
                UMUserRole umUserRole = it.next();
                if (umUserRole.getIsActive()) {
                    SimpleGrantedAuthority authority;
                    authority = new SimpleGrantedAuthority(Long.toString(umUserRole.getuMUserRolePK().getRole()));
                    authorities.add(authority);
                }
            }
        }
        return new User(uMUser.getUserId(), uMUser.getPassword(), uMUser.getIsActive(), true, true, true, authorities);
    }
}
