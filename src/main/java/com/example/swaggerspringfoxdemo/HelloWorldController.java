package com.example.swaggerspringfoxdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    /**
     * 访问：http://localhost:8080/helloWorld
     *
     * @return helloWorld
     */
    @RequestMapping("/helloWorld")
    public String helloWorld(){
        return "helloWorld";
    }
}
