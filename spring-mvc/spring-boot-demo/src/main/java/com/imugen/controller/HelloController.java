package com.imugen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author Gakki
 * @date 2018/12/23 - 20:02
 */
@Controller
public class HelloController {

    @RequestMapping( path = "/hello" )
    public String sayHello(Map<String, Object> map) {
        System.out.println("111");
        map.put("age", "18");
        return "success";
    }

    @GetMapping( "/num" )
    public int getNum() {
        return 3000;
    }
}
