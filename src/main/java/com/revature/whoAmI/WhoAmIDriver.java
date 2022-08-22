package com.revature.whoAmI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class WhoAmIDriver {

    @GetMapping("/test")
    public String message(){
        return "IT'S WORKING!!";
    }
    public static void main(String[] args) {
        SpringApplication.run(WhoAmIDriver.class, args);
    }
}
