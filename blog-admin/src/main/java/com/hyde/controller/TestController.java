package com.hyde.controller;

import com.hyde.util.RedisUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "测试接口", description = "测试相关接口")
@RestController
@RequestMapping("/sys")
@Slf4j
public class TestController {
    @Operation(
            summary = "测试简要",
            description = "测试详细步骤"
    )
    @GetMapping("/test")
    public String test(){
        return "test";
    }
    @Operation(summary = "gitBuilderTest")
    @GetMapping("/testGitBuilder")
    public void testGitBuilder(){
        RedisUtil.set("hyde","dimash");
    }
}
