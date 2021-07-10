package com.imooc.concurrency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Daniel Liu 2019/12/24 19:32
 */
@RestController
public class Test {

    @GetMapping( "/test" )
    public String test() {
        return "test";
    }
}