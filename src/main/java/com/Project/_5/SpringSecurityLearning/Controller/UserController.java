package com.Project._5.SpringSecurityLearning.Controller;

import com.Project._5.SpringSecurityLearning.Entity.User;
import com.Project._5.SpringSecurityLearning.Repository.UserRepo;
import com.Project._5.SpringSecurityLearning.Service.JwtService;
import com.Project._5.SpringSecurityLearning.Service.UserService;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/users")
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserController(PasswordEncoder passwordEncoder, UserService userService, UserRepo userRepo, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.userRepo = userRepo;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }


    @GetMapping("/users")
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
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),  user.getPassword())
        );

        if(authenticate.isAuthenticated())
        {
            return jwtService.getJwtToken(user);

        }
        else return "Authentication failed!!";
    }

    /*                             Without Authentication manager
    @PostMapping("/login")
    public String loginFailOrPass(@RequestBody User user)
    {

        String res="";
        if (userRepo.existsByUsername(user.getUsername()))
        {
            User dbUser= userRepo.findByUsername(user.getUsername());
            //{
//            String password=user.getPassword();         //No need to do all this
//            String encodedPassword=passwordEncoder.encode(password);
//            System.out.println("EncodedPassword="+encodedPassword);
//            System.out.println("DbUserPassword="+dbUser.getPassword());
                //We have this method in PasswordEncoder
                //boolean matches(CharSequence rawPassword, String encodedPassword);
            //}
            if(passwordEncoder.matches(user.getPassword(),dbUser.getPassword()))
            res="Login Success and password matches as well";
            else
            res="Login Failed... Enter the correct password!";
        }
        else {
            res="No such user with username = "+ user.getUsername()+" is present";
        }

        return res;
    }

     */
}
