package com.imugen.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Gakki
 * @date 2018/12/13 - 11:56
 */
@Data
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private String userAddress;
    private String userSex;
    private Date userBirthday;
}
