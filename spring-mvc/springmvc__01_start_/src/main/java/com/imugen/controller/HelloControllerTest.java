package com.imugen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Gakki
 * @date 2018/12/23 - 20:02
 */
@Controller
public class HelloControllerTest {
    private String str;



    @RequestMapping( path = "/hello1" )
    public String sayHello() {
        if (str == null) {
            str = "shit";
        } else {
            str = "shitttt";
        }
        System.out.println(str);
        return "success";
    }
}
