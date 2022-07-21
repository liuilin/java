package com.wangwenjun.guava.utilities;

import com.google.common.base.Splitter;
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
public class GuavaSplitterWithPostfixPluginTest {

    public static final String STR = "四川省/成都市";

    // ================================ split to array/list ================================

    @Test
    public void testSplit() {
        String[] split = STR.split("/");
        List<String> strings = Arrays.asList(split);
        Assert.assertEquals(2, strings.size());
        Assert.assertEquals("四川省", strings.get(0));
        Assert.assertEquals("成都市", strings.get(1));
    }

    @Test
    public void testSplitByRegexp() {
        List<String> result = Splitter.onPattern("/").trimResults().omitEmptyStrings().splitToList(STR);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("四川省", result.get(0));
        Assert.assertEquals("成都市", result.get(1));
    }

    @Test
    public void testSplitFixLength() {
        List<String> result = Splitter.fixedLength(4).splitToList("aaaabbbbccccdddd");
        Assert.assertEquals(4, result.size());
        Assert.assertEquals(result.get(0), "aaaa");
        Assert.assertEquals(result.get(3), "dddd");
    }


}
