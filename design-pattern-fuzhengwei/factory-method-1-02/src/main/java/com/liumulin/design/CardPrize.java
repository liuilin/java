package com.liumulin.design;

import com.liumulin.design.store.CardPrizeService;

/**
 * @author liuqiang
 * @since 2022-05-20
 */
public class CardPrize extends Prize {
    @Override
    public Award createAward() {
        return new CardPrizeService();
    }
}
