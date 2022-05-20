package com.liumulin.design;

public abstract class Prize {

//        public IPrize getPrizeService(Integer prizeType) {
//                if (null == prizeType) return null;
//                if (PrizeTypeEnum.CARD.getCode() == prizeType) return new CardPrizeService();
//                if (PrizeTypeEnum.COUPON.getCode() == prizeType) return new CouponPrizeService();
//                if (PrizeTypeEnum.PHYSICAL_GOODS.getCode() == prizeType) return new PhysicalGoodsPrizeService();
//                throw new RuntimeException("不存在的奖品类型");
//        }


    public abstract Award createAward();


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
