package com.imooc.concurrency.example.publish;

import com.imooc.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 非安全对象发布
 *
 * @author Daniel Liu 2019/12/26 16:22
 */
@Slf4j
@NotThreadSafe
public class UnSafeObjPublish {

    private String[] state = {"a", "b", "c"};

    public String[] getState() {
        return state;
    }

    public static void main(String[] args) {
        UnSafeObjPublish unSafeObjPublish = new UnSafeObjPublish();
        log.info("{}", Arrays.asList(unSafeObjPublish.getState()));

        unSafeObjPublish.state[0] = "d";
        log.info("{}", Arrays.asList(unSafeObjPublish.getState()));
    }
}