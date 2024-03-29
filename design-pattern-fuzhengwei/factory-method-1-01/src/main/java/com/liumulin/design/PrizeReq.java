package com.liumulin.design;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 用继承的方式，Map 开发一时爽，维护火葬场
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PrizeReq {
    private String id;
    private String userId;                 // 用户唯一ID
    private Integer awardType;          // 奖品类型(可以用枚举定义)；1优惠券、2实物商品、3第三方兑换卡(爱奇艺)
    private String awardNumber;         // 奖品编号；sku、couponNumber、cardId
    private String bizId;               // 业务ID，防重复
//    private Map<String, String> extMap; // 扩展信息
}
