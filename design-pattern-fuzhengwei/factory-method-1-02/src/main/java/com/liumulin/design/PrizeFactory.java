package com.liumulin.design;

import com.liumulin.design.store.IPrize;
import com.liumulin.design.store.PrizeTypeEnum;
import com.liumulin.design.store.impl.CardPrizeService;
import com.liumulin.design.store.impl.CouponPrizeService;
import com.liumulin.design.store.impl.PhysicalGoodsPrizeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrizeFactory {

        public IPrize getPrizeService(Integer prizeType) {
        if (null == prizeType) return null;
        if (PrizeTypeEnum.CARD.getCode() == prizeType) return new CardPrizeService();
        if (PrizeTypeEnum.COUPON.getCode() == prizeType) return new CouponPrizeService();
        if (PrizeTypeEnum.PHYSICAL_GOODS.getCode() == prizeType) return new PhysicalGoodsPrizeService();
        throw new RuntimeException("不存在的奖品类型");
    }
//    public static Map<Integer, IPrize> map;
//
//    public static PrizeFactory getPrizeService() {
//        List<IPrize> strategies = new ArrayList<>();
//        strategies.add(new CardPrizeService());
//        strategies.add(new CouponPrizeService());
//        strategies.add(new PhysicalGoodsPrizeService());
//        map = strategies.stream().collect(Collectors.toMap(IPrize::getPrizeType, strategy -> strategy));
//        return new PrizeFactory();
//    }
//
//    public static IPrize getPrize(Integer prizeType) {
//        return map.get(prizeType);
//    }
//
//    public static PrizeFactory getInstance() {
//        return Holder.instance;
////        PrizeFactory.getPrizeService();
//    }
//
//    //    public static PrizeFactory getInstance() {
////        public static PrizeFactory instance = PrizeFactory.getPrizeService();
////    }
////
//    public static class Holder {
//        public static PrizeFactory instance = PrizeFactory.getPrizeService();
//    }

}
