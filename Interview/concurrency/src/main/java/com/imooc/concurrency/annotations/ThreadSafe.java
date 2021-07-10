package com.imooc.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 线程安全类
 *
 * @author Daniel Liu 2019/12/24 19:26
 */
@Target( ElementType.TYPE )
@Retention( RetentionPolicy.SOURCE)
public @interface ThreadSafe {

    String value() default "";
}
