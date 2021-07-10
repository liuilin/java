package com.imugen.controller;

import com.imugen.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Daniel Liu 2020/3/12 18:49
 */
@Controller
@RequestMapping( "user" )
public class HelloWorld {

    @RequestMapping( "/hi" )
    public String hi() {
        System.out.println("hi Gakki...");
        return "success";
    }

    @RequestMapping( "/account" )
    public void account(Account account) {
        System.out.println(account);
    }

}