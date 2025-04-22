package com.prashantsarvaiya.firstpro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class MySecondController {
    @GetMapping("/")
    public String method(){
        return "From method v1";
    }
}
