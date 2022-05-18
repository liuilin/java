package com.liumulin.design.coupon;

/**
 * 模拟优惠券服务
 */
public class CouponService {

    public CouponResult sendCoupon(String userId, String couponNumber, String uuid) {
        System.out.println("模拟发放优惠券一张：" + userId + "," + couponNumber + "," + uuid);
        return new CouponResult("0000", "发放成功");
    }

}
