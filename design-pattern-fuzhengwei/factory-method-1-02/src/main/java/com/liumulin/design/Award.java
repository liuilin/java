package com.liumulin.design;

/**
 * 发放奖品
 *
 * @author liuqiang
 * @since 2022-05-20
 */
public interface Award {
    /**
     * 发放奖品
     */
    void sendPrize(PrizeReq prizeReq);
}
