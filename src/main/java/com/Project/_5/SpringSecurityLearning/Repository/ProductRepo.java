package com.Project._5.SpringSecurityLearning.Repository;

import com.Project._5.SpringSecurityLearning.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepo extends JpaRepository<Product, UUID>
{

}
