package com.Project._5.SpringSecurityLearning.Security;


import com.Project._5.SpringSecurityLearning.Entity.User;
import com.Project._5.SpringSecurityLearning.Repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component      //thereby telling spring that we will wnt to have the object of this class somewhere in the future
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(username);
        if(Objects.isNull(user))       // similar to if(user==null)
        {
            System.out.println("User not availableeeeee");
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomUserDetails(user);
    }
}
