package com.api.finlytics.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class investmentcontroller {

    @GetMapping("home")
    public String HelloFinlytics(){
        return "Hello Finlytics";
    }

}
