package com.Project._5.SpringSecurityLearning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Check
{
    @GetMapping("/check")
    public String Greeting()
    {
        return "Everything's working";
    }
}
