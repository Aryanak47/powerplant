package com.proshore.powerplant.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "health")
public class HealthCheckup {
    @GetMapping
    public String getBatteries(){
        return "Server is up and running";
    }
}
