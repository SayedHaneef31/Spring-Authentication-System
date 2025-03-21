package com.Project._5.SpringSecurityLearning.Controller;

import com.Project._5.SpringSecurityLearning.Entity.Product;
import com.Project._5.SpringSecurityLearning.Service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{

    private final ProductService productService;

    public ProductController(ProductService productService) {
        System.out.println("We are in the /products controller");
        this.productService = productService;
    }

    //Local DB
//    private List<Product> localDB=new ArrayList<>(
//            Arrays.asList(
//                    new Product( "Laptop", 75000.0),
//                    new Product( "Smartphone", 25000.0),
//                    new Product( "Headphones", 3000.0),
//                    new Product( "Smartwatch", 5000.0)
//            )
//
//    );

    @GetMapping()
    public List<Product> getAllProducts()
    {
        //System.out.println("inside getAllProducts() method");
        return productService.listProducts();
    }

    @GetMapping("/csrf")             //this method will get me the csrf token for the already authenticated user
                                     //This api will only hity when the user is authenticated.
    public CsrfToken getCSRFToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("")
    public Product CreateProduct(@RequestBody Product product)
    {
        //if (product.nam()==null) throw new NullPointerException("Product Should have a valid name,It should not be empty!!");
        //if (product.getPrice()==null) throw new NullPointerException("PRoduct Should have a valid price,It should not be empty!!");
        return productService.cretaeAProduct(product);
    }
}
