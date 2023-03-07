package com.scrapper.app.scrapper.Navigator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @GetMapping("/")
    public String helloSpring(){
        return "hello spring";
    }
}
