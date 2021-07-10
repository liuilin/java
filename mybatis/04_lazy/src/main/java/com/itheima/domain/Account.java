package com.imugen.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Gakki
 * @date 2018/12/16 - 14:40
 */
@Data
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;

    /**
     * 一对一
     */
    private User user;
}
