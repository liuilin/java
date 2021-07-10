package com.imugen.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * @author Daniel
 * @date 2020/11/03
 */
@NoArgsConstructor
@Data
public final class TaxLine {
    private String title;
    private BigDecimal rate;
    private BigDecimal price;
    public TaxLine(String title, BigDecimal rate, BigDecimal price) {
        this.title = title;
        this.rate = rate;
        this.price = price;
    }
    public String getTitle() {
        return this.title;
    }
    public BigDecimal getRate() {
        return this.rate;
    }
    public BigDecimal getPrice() {
        return this.price;
    }
    @Override
    public String toString() {
        return "TaxLine = title:\"" + this.title + "\", rate:" + this.rate + ", price:" + this.price;
    }
}
