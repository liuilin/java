package com.imooc.concurrency.example.publish;

import lombok.extern.slf4j.Slf4j;

/**
 * 对象溢出创建
 *
 * @author Daniel Liu 2019/12/26 16:39
 */
@Slf4j
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}",this);
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        Escape escape = new Escape();
    }
}