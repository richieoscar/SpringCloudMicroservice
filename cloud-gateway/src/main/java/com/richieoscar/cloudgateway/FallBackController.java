package com.richieoscar.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/studentServiceFallBack")
    public String studentServiceFallBackMethod() {
        return "Student Service is Down";
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBack() {
        return "Department Service is Down";
    }
}
