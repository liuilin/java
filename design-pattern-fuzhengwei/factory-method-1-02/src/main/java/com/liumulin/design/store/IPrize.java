package com.liumulin.design.store;

import com.liumulin.design.PrizeReq;

public interface IPrize {

    /**
     * 发送奖品
     */
    void sendPrize(PrizeReq prizeReq);

    Integer getPrizeType();
}
