package com.imugen.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Gakki
 * @date 2018/12/17 - 10:33
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}
