package com.Project._5.SpringSecurityLearning.Service.Impl;

import com.Project._5.SpringSecurityLearning.Entity.User;
import com.Project._5.SpringSecurityLearning.Repository.UserRepo;
import com.Project._5.SpringSecurityLearning.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService
{

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> listAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }
}
