package com.Project._5.SpringSecurityLearning.Service;

import com.Project._5.SpringSecurityLearning.Entity.Product;

import java.util.List;

public interface ProductService
{
     List<Product> listProducts();

     Product cretaeAProduct(Product product);

}
