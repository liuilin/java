package com.wangwenjun.guava.utilities;

import com.google.common.base.Joiner;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Guava 工具类测试
 *
 * @author liuqiang
 * @date 2022/07/05
 */
public class GuavaJoinerWithPostfixPluginTest {

    public static final List<String> LIST = Arrays.asList("四川省", "成都市", "锦江区", "蓝光凯丽香江");
    public static final List<String> LIST_WITH_NULL = Arrays.asList("四川省", "成都市", "锦江区", "蓝光凯丽香江", null);

    @Test
    public void testJoin() {
        String result = Joiner.on("/").join(LIST);
        Assert.assertEquals("四川省/成都市/锦江区/蓝光凯丽香江", result);
    }

    @Test
    public void testJoinSkipNulls() {
        String result = Joiner.on("/").skipNulls().join(LIST_WITH_NULL);
        Assert.assertEquals("四川省/成都市/锦江区/蓝光凯丽香江", result);
    }

    @Test
    public void testReplaceNull(){
        String result = Joiner.on("/").useForNull("未知").join(LIST_WITH_NULL);
        Assert.assertEquals("四川省/成都市/锦江区/蓝光凯丽香江/未知", result);
    }

}
