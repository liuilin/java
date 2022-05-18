package com.liumulin.design;

import lombok.*;

/**
 * @author liuqiang
 * @since 2022-05-18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PhysicalGoods extends AwardReq {
    private String consigneeUserName;
    private String consigneeUserPhone;
    private String consigneeUserAddress;
}
