package com.liumulin.design.store.impl;

import com.liumulin.design.PrizeReq;
import com.liumulin.design.card.IQiYiCardService;
import com.liumulin.design.store.IGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CardGoodsService implements IGoods {

    private final Logger logger = LoggerFactory.getLogger(CardGoodsService.class);

    // 模拟注入
    private final IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendPrize(PrizeReq prizeReq) {
        String userId = prizeReq.getUserId();
        String mobile = queryUserMobile(userId);
        String bizId = prizeReq.getBizId();
        iQiYiCardService.grantToken(mobile, bizId);
        logger.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} ", userId, prizeReq.getId(), bizId);
        logger.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryUserMobile(String userId) {
        return "15200101232";
    }

}
