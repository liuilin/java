package com.imooc.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 不推荐写法
 *
 * @author Daniel Liu 2019/12/26 8:20
 */
@Target( ElementType.TYPE )
@Retention( RetentionPolicy.SOURCE )
public @interface NotRecommend {

    String value() default "";
}
