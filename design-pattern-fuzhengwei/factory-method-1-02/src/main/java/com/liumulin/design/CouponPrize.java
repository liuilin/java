package com.liumulin.design;

import com.liumulin.design.store.CouponPrizeService;

/**
 * 优惠券奖品工厂类
 *
 * @author liuqiang
 * @since 2022-05-20
 */
public class CouponPrize extends Prize {
    @Override
    public Award createAward() {
        return new CouponPrizeService();
    }
}
