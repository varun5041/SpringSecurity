package com.security.learn.securityProject.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class ApiController
{

    // first end point
    @GetMapping("/route1")
    public String route1(Principal principal){
        return "this is first route 1 "+principal.getName();
    }

    // second end point
    @GetMapping("/route2")
    public String route2(){
        return "this is first route 2";
    }
}
