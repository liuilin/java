package com.liumulin.design;

/**
 * 发放奖品
 *
 * @author liuqiang
 * @since 2022-05-20
 */
public class SendPrizeTest {
    public static void main(String[] args) {
//        Prize prize = new CardPrize();
        Prize prize = new PhysicalGoodsPrize();
        Award award = prize.createAward();
        // 第三方兑换卡
//        award.sendPrize(PrizeReq.builder().userId("10001").id("AQY1xjkUodl8LO975GdfrYUio").build());

        // 优惠券
//        award.sendPrize(PrizeReq.builder().userId("10001").id("EGM1023938910232121323432").bizId("791098764902132").build());

        // 实物商品
        award.sendPrize(PhysicalGoods.builder()
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
