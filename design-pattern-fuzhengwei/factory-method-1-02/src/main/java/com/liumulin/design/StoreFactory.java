package com.liumulin.design;

import com.liumulin.design.store.IGoods;
import com.liumulin.design.store.impl.CardGoodsService;
import com.liumulin.design.store.impl.CouponGoodsService;
import com.liumulin.design.store.impl.PhysicalGoodsService;

public class StoreFactory {

    public IGoods getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponGoodsService();
        if (2 == commodityType) return new PhysicalGoodsService();
        if (3 == commodityType) return new CardGoodsService();
        throw new RuntimeException("不存在的商品服务类型");
    }

}
