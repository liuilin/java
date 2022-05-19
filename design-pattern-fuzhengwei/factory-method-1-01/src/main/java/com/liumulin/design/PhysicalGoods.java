package com.liumulin.design;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author liuqiang
 * @since 2022-05-18
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PhysicalGoods extends PrizeReq {
    private String consigneeUserName;
    private String consigneeUserPhone;
    private String consigneeUserAddress;
}
