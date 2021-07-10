package com.imugen.domain;

import lombok.Data;

/**
 * @author Gakki
 * @date 2018/12/17 - 15:12
 */
@Data
public class Account {
    private Integer id;
    private Integer uid;
    private Double money;

    private User user;
}
