package com.hyde.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "测试controller")
@RestController
public class TestController {

    @Operation(summary = "测试简要", description = "测试详细步骤")
    @GetMapping("/test")
    public String test(){
        return "test";
    }


    @Operation(summary = "gitbuilderTest")
    @GetMapping("/testGitBuilder")
    public String testGitBuilder(){
        return "Hello GitBuilder";
    }
}
