package com.Project._5.SpringSecurityLearning.Repository;

import com.Project._5.SpringSecurityLearning.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User,UUID> {

    boolean existsByUsername(String username);
    User findByUsername(String username);
}
