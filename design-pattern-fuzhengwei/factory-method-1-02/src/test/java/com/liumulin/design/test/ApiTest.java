package com.liumulin.design.test;

import com.liumulin.design.PhysicalGoods;
import com.liumulin.design.PrizeReq;
import com.liumulin.design.StoreFactory;
import com.liumulin.design.store.IPrize;
import com.liumulin.design.store.PrizeTypeEnum;
import org.junit.Test;

public class ApiTest {

    @Test
    public void whenGoodsType_thenSendPrize() {
        StoreFactory storeFactory = new StoreFactory();

        // 1. 第三方兑换卡(爱奇艺)
        IPrize cardService = storeFactory.getPrizeService(1);
        cardService.sendPrize(PrizeReq.builder().userId("10001").id("AQY1xjkUodl8LO975GdfrYUio").build());

        // 2. 优惠券
        IPrize couponService = storeFactory.getPrizeService(2);
        couponService.sendPrize(PrizeReq.builder().userId("10001").id("EGM1023938910232121323432").bizId("791098764902132").build());

        // 3. 实物商品
        IPrize physicalGoodsService = storeFactory.getPrizeService(3);
        physicalGoodsService.sendPrize(
                PhysicalGoods.builder()
                        .consigneeUserName("Daniel")
                        .consigneeUserPhone("19121945219")
                        .consigneeUserAddress("四川省成都市温江区富和苑")

                        // 奖品共有属性
                        .userId("10001")
                        .id("9820198721311")
                        .bizId("1023000020112221113")
                        .build()
        );

    }

}
