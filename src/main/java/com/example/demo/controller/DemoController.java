package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wujy , 2018/8/15
 */
@RestController
public class DemoController {
    @GetMapping("/go")
    public String go() {
        return "success";
    }
}
