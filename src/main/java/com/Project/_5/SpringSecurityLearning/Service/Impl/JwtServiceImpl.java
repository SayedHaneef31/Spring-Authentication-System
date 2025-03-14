package com.Project._5.SpringSecurityLearning.Service.Impl;

import com.Project._5.SpringSecurityLearning.Entity.User;
import com.Project._5.SpringSecurityLearning.Service.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//import static org.springframework.cache.interceptor.SimpleKeyGenerator.generateKey;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")       //Application properties me jwt.secret define karna padega
    private String secretKey;
    /*
    Note: For a Safer Method.....USE ENVIRONMENT VARIABLE:
    1. Set an environment variable (JWT_SECRET) in your system:
    set JWT_SECRET=YourSuperSecretKeyHere   in terminalL
    2. Access it in application.properties
    jwt.secret=${JWT_SECRET}   in application.properties
    */


    @Override
    public String getJwtToken(User user)      //generates a JWT (JSON Web Token) for a given User
    {
        Map<String,Object> claims=new HashMap<>();
        //LocalDateTime now =

        return Jwts.builder()   // This creates a new JWT builder instance using jjwt (JSON Web Token library), initializes a JWT object, allowing us to set various fields
                .claims()    // initializes the claims section of the JWT.
                .add(claims)
                .subject(user.getUsername())
                .issuer("HANEEF")    //Helps in tracking which service generated the JWT.
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+60*10*1000))
                .and()
                .signWith(generateKey())  //Signing ensures the token cannot be tampered with,Any modification to the JWT will make it invalid during verification
                .compact(); //Generates the final compact JWT string.


    }


    private SecretKey generateKey()
    {
        byte[] decode= Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(decode);
    }
}
