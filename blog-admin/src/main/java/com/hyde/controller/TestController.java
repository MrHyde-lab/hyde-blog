package com.hyde.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {

    @Operation(summary = "test")
    @GetMapping("/test")
    public void test(){
        System.out.println("test");
    }
}
