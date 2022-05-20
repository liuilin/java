package com.liumulin.design.creational.factorymethod2;

import lombok.*;

/**
 * @author liuqiang
 * @since 2022-05-20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
