package com.liumulin.design.store.impl;

import com.alibaba.fastjson.JSON;
import com.liumulin.design.PrizeReq;
import com.liumulin.design.coupon.CouponResult;
import com.liumulin.design.coupon.CouponService;
import com.liumulin.design.store.IGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CouponGoodsService implements IGoods {

    private final Logger logger = LoggerFactory.getLogger(CouponGoodsService.class);

    private final CouponService couponService = new CouponService();

    @Override
    public void sendPrize(PrizeReq prizeReq) {
        String goodsId = prizeReq.getId();
        String userId = prizeReq.getUserId();
        String bizId = prizeReq.getBizId();
        CouponResult couponResult = couponService.sendCoupon(userId, goodsId, bizId);
        logger.info("请求参数[优惠券] => userId：{} goodsId：{} bizId：{} ",userId, goodsId, bizId);
        logger.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
    }

}
