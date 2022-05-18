package com.liumulin.design;

import com.alibaba.fastjson.JSON;
import com.liumulin.design.card.IQiYiCardService;
import com.liumulin.design.coupon.CouponResult;
import com.liumulin.design.coupon.CouponService;
import com.liumulin.design.goods.DeliverReq;
import com.liumulin.design.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 模拟发奖服务
 */
public class PrizeController {

    private Logger logger = LoggerFactory.getLogger(PrizeController.class);

    public AwardRes awardToUser(AwardReq req) {
        String reqJson = JSON.toJSONString(req);
        AwardRes awardRes = null;
        try {
            logger.info("奖品发放开始{}。req:{}", req.getUserId(), reqJson);
            // 按照不同类型方法商品[1优惠券、2实物商品、3第三方兑换卡(爱奇艺)]
            if (req.getAwardType() == 1) {
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getUserId(), req.getAwardNumber(), req.getBizId());
                if ("0000".equals(couponResult.getCode())) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", couponResult.getInfo());
                }
            } else if (req.getAwardType() == 2) {
                PhysicalGoods goods = (PhysicalGoods) req;


                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(req.getUserId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getUserId()));
                deliverReq.setSku(goods.getAwardNumber());
                deliverReq.setOrderId(goods.getBizId());
                deliverReq.setConsigneeUserName(goods.getConsigneeUserName());
                deliverReq.setConsigneeUserPhone(goods.getConsigneeUserPhone());
                deliverReq.setConsigneeUserAddress(goods.getConsigneeUserAddress());
                Boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", "发放失败");
                }
            } else if (req.getAwardType() == 3) {
                String bindMobileNumber = queryUserPhoneNumber(req.getUserId());
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken(bindMobileNumber, req.getAwardNumber());
                awardRes = new AwardRes("0000", "发放成功");
            }
            logger.info("奖品发放完成{}。", req.getUserId());
        } catch (Exception e) {
            logger.error("奖品发放失败{}。req:{}", req.getUserId(), reqJson, e);
            awardRes = new AwardRes("0001", e.getMessage());
        }

        return awardRes;
    }

    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }

}
