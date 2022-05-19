package org.itstack.demo.test;

import com.alibaba.fastjson.JSON;
import com.liumulin.design.PrizeReq;
import com.liumulin.design.PrizeRes;
import com.liumulin.design.PhysicalGoods;
import com.liumulin.design.PrizeController;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_awardToUser() {
        PrizeController prizeController = new PrizeController();

        discountCoupon(prizeController);
        physicalGoods(prizeController);
        iQiYi(prizeController);
    }

    private void iQiYi(PrizeController prizeController) {
        System.out.println("\r\n第三方兑换卡(爱奇艺)\r\n");
        PrizeReq req03 = new PrizeReq();
        req03.setUserId("10001");
        req03.setAwardType(3);
        req03.setAwardNumber("AQY1xjkUodl8LO975GdfrYUio");

        PrizeRes prizeRes03 = prizeController.awardToUser(req03);
        logger.info("请求参数：{}", JSON.toJSON(req03));
        logger.info("测试结果：{}", JSON.toJSON(prizeRes03));
    }

    private void physicalGoods(PrizeController prizeController) {
        System.out.println("\r\n模拟方法实物商品\r\n");
        // 模拟方法实物商品
        PhysicalGoods req02 = new PhysicalGoods();
        req02.setUserId("10001");
        req02.setAwardType(2);
        req02.setAwardNumber("9820198721311");
        req02.setBizId("1023000020112221113");

        req02.setConsigneeUserName("daniel");
        req02.setConsigneeUserPhone("19121945219");
        req02.setConsigneeUserAddress("四川省成都市温江区富和苑");

        PrizeRes prizeRes02 = prizeController.awardToUser(req02);
        logger.info("请求参数：{}", JSON.toJSON(req02));
        logger.info("测试结果：{}", JSON.toJSON(prizeRes02));
    }

    private void discountCoupon(PrizeController prizeController) {
        System.out.println("\r\n模拟发放优惠券测试\r\n");
        // 模拟发放优惠券测试
        PrizeReq req01 = new PrizeReq();
        req01.setUserId("10001");
        req01.setAwardType(1);
        req01.setAwardNumber("EGM1023938910232121323432");
        req01.setBizId("791098764902132");
        PrizeRes prizeRes01 = prizeController.awardToUser(req01);

        logger.info("请求参数：{}", JSON.toJSON(req01));
        logger.info("测试结果：{}", JSON.toJSON(prizeRes01));
    }

}
