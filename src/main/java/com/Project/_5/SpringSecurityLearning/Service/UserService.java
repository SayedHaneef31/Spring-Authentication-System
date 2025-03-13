package com.Project._5.SpringSecurityLearning.Service;

import com.Project._5.SpringSecurityLearning.Entity.User;

import java.util.List;

public interface UserService
{
     List<User> listAllUsers();

     User createUser(User user);
}
