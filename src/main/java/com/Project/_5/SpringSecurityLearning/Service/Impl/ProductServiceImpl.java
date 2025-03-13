package com.Project._5.SpringSecurityLearning.Service.Impl;

import com.Project._5.SpringSecurityLearning.Entity.Product;
import com.Project._5.SpringSecurityLearning.Repository.ProductRepo;
import com.Project._5.SpringSecurityLearning.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService
{

    //@Autowired
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> listProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product cretaeAProduct(Product product) {

        Product prod=new Product(product.getName(),product.getPrice());
//        prod.setName(product.getName());
//        prod.setPrice(product.getPrice());
        return productRepo.save(prod);
    }
}
