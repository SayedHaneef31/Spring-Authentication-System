package com.Project._5.SpringSecurityLearning.Service;

import com.Project._5.SpringSecurityLearning.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService
{
    String getJwtToken(User user);

    String ectractUserName(String jwt);

    boolean isTokenValid(String jwt, UserDetails userDetails);
}
