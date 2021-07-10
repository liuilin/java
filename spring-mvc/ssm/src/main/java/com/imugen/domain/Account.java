package com.imugen.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Gakki
 * @date 2018/12/26 - 17:55
 */
@Data
public class Account implements Serializable {
    private Integer id;
    private String name;
    private double money;
}
