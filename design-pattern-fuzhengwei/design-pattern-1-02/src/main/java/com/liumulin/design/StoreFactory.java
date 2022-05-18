package com.liumulin.design;

import com.liumulin.design.store.ICommodity;
import com.liumulin.design.store.impl.CardCommodityService;
import com.liumulin.design.store.impl.CouponCommodityService;
import com.liumulin.design.store.impl.GoodsCommodityService;

public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) {
            return null;
        }
        switch (commodityType) {
            case 1:
                return new CouponCommodityService();
            case 2:
                return new GoodsCommodityService();
            case 3:
                return new CardCommodityService();
        }
        throw new RuntimeException("不存在的商品服务类型");
    }

}
