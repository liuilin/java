package com.imooc.framework;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class FrameworkApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void t1(){
        Console.log("{}",DateUtil.format(new Date(), "yyyy-MM-dd"));
    }

}
