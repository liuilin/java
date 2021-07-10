package com.imooc.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 推荐写法
 *
 * @author Daniel Liu 2019/12/26 8:17
 */
@Target( ElementType.TYPE )
@Retention( RetentionPolicy.SOURCE )
public @interface Recommend {

    String value() default "";
}
