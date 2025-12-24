package com.luv2code.jobportal.util;

import com.luv2code.jobportal.entity.Users;
import com.luv2code.jobportal.entity.UsersType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final Users user;

    public CustomUserDetails(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    
        UsersType usersType = user.getUserTypeId();
    
        if (usersType == null || usersType.getUserTypeName() == null) {
            return Collections.singletonList(
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }
    
        // Convert DB value → Spring Security role
        // Recruiter   → ROLE_RECRUITER
        // Job Seeker  → ROLE_JOB_SEEKER
        String role = "ROLE_" +
                usersType.getUserTypeName()
                        .toUpperCase()
                        .replace(" ", "_");
    
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
    

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isActive(); // correct getter
    }
}
