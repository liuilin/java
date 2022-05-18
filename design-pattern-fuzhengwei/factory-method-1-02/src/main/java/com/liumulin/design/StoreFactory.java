package com.liumulin.design;

import com.liumulin.design.store.IPrize;
import com.liumulin.design.store.PrizeTypeEnum;
import com.liumulin.design.store.impl.CardPrizeService;
import com.liumulin.design.store.impl.CouponPrizeService;
import com.liumulin.design.store.impl.PhysicalGoodsPrizeService;

public class StoreFactory {

    public IPrize getPrizeService(PrizeTypeEnum prizeType) {
        if (null == prizeType) return null;
        if (PrizeTypeEnum.CARD == prizeType) return new CardPrizeService();
        if (PrizeTypeEnum.COUPON == prizeType) return new CouponPrizeService();
        if (PrizeTypeEnum.PHYSICAL_GOODS == prizeType) return new PhysicalGoodsPrizeService();
        throw new RuntimeException("不存在的奖品类型");
    }

}
