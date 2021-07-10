package com.imugen;

import java.util.List;

/**
 * @author liuqiang
 * @since 2021-03-16
 */
class Goods {
    /** 商品名称 */
    String name;
    /** 商品属性，(String)表示泛型为String */
    List<String> attrList;
    /** 商品数量 */
    int count;
}
class MergeUtil {
    /** TODO */
    static List mergeGoods(List goodsList) {
        return null;
}
}
//例如：
//        【合并前】的商品：
//        红富士， [红色, 纯天然, 很甜]，10个
//        红富士， [很甜, 红色, 纯天然]，2个
//        红富士， [纯天然, 红色]，5个
//        小金苹果， [纯天然, 红色]，20个
//        【合并后】的商品：
//        红富士，[红色, 纯天然, 很甜]，12个
//        红富士，[纯天然, 红色]，5个
//        小金苹果，[纯天然, 红色]，20个
//        【问答题】 （20分）


