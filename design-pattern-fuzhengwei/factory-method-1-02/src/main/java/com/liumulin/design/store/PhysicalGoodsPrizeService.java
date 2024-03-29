package com.liumulin.design.store;

import com.liumulin.design.Award;
import com.liumulin.design.PhysicalGoods;
import com.liumulin.design.PrizeReq;
import com.liumulin.design.goods.DeliverReq;
import com.liumulin.design.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhysicalGoodsPrizeService implements Award {

    private final Logger logger = LoggerFactory.getLogger(PhysicalGoodsPrizeService.class);

    private final GoodsService goodsService = new GoodsService();

    @Override
    public void sendPrize(PrizeReq prizeReq) {
        String userId = prizeReq.getUserId();
        String goodsId = prizeReq.getId();
        String bizId = prizeReq.getBizId();
        PhysicalGoods prize = (PhysicalGoods) prizeReq;


        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(userId));
        deliverReq.setUserPhone(queryUserPhoneNumber(userId));
        deliverReq.setSku(goodsId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(prize.getConsigneeUserName());
        deliverReq.setConsigneeUserPhone(prize.getConsigneeUserPhone());
        deliverReq.setConsigneeUserAddress(prize.getConsigneeUserAddress());

        Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        logger.info("请求参数[实物商品] => userId：{} goodsId：{} bizId：{} ", userId, goodsId, bizId);
        logger.info("测试结果[实物商品]：{}", isSuccess);
        if (!isSuccess) {
            throw new RuntimeException("实物商品发放失败");
        }
    }

//    @Override
//    public Integer getPrizeType() {
//        return PrizeTypeEnum.PHYSICAL_GOODS.getCode();
//    }

    private String queryUserName(String userId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String userId) {
        return "15200101232";
    }

}
