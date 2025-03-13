package com.Project._5.SpringSecurityLearning.Controller;

import com.Project._5.SpringSecurityLearning.Entity.User;
import com.Project._5.SpringSecurityLearning.Repository.UserRepo;
import com.Project._5.SpringSecurityLearning.Service.UserService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepo userRepo;

    public UserController(UserService userService, UserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }


    @GetMapping("users")
    public List<User> getAllUsers() {return userService.listAllUsers();}

    @PostMapping("/register")
    public User createAUser(@RequestBody User user)
    {
        if (userRepo.existsByUsername(user.getUsername())) {
            throw new DuplicateKeyException("Username already exists!");
        }
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String loginFailOrPass(@RequestBody User user)
    {

        String res="Login failed";
        if (userRepo.existsByUsername(user.getUsername()))
        {
            User dbUser= userRepo.findByUsername(user.getUsername());
            if(dbUser.getPassword().equals(user.getPassword()))
            res="Login Success and password matches as well";
            else
            res="Login Success with username only";
        }

        return res;
    }
}
