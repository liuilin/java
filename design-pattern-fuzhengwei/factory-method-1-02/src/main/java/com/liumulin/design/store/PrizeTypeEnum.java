package com.liumulin.design.store;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * 奖品类型
 *
 * @author liuqiang
 * @since 2022-05-18
 */
@Getter
@AllArgsConstructor
public enum PrizeTypeEnum {
    UNKNOWN(0, "未知"),
    CARD(1, "兑换卡"),
    COUPON(2, "优惠券"),
    PHYSICAL_GOODS(3, "实物商品"),
    ;


    private final int code;
    private final String desc;

    public static String getDesc(Integer code) {
        return valueOf(Optional.ofNullable(code).orElse(0)).desc;
    }

    public static PrizeTypeEnum valueOf(Integer code) {
        return Arrays.stream(values())
                .filter(v -> v.getCode() == code)
                .findFirst()
                .orElse(PrizeTypeEnum.UNKNOWN);//.orElseThrow(() -> new IllegalArgumentException("No such enum object for the code : " + code));
    }

    public static boolean containsValue(Integer code) {
        return valueOf(code) != null;
    }

}
