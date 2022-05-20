package com.liumulin.design;

import com.liumulin.design.store.PhysicalGoodsPrizeService;

/**
 * 实物奖品
 *
 * @author liuqiang
 * @since 2022-05-20
 */
public class PhysicalGoodsPrize extends Prize {
    @Override
    public Award createAward() {
        return new PhysicalGoodsPrizeService();
    }
}
