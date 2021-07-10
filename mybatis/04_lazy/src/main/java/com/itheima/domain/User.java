package com.imugen.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Gakki
 * @date 2018/12/13 - 11:56
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String address;
    private String sex;
    private Date birthday;

    /**
     * 一对多
     */
    private List<Account> accounts;
}
