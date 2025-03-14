package com.Project._5.SpringSecurityLearning.Service;

import com.Project._5.SpringSecurityLearning.Entity.User;

public interface JwtService
{
    String getJwtToken(User user);
}
