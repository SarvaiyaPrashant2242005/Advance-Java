package com.prashantsarvaiya.firstpro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping(value = "/{name}")
    public String Greetings(@PathVariable String name) {
        return "Greetings from Prashant Sarvaiya to" + name + "!";
    }

}