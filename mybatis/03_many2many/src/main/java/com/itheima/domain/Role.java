package com.imugen.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Gakki
 * @date 2018/12/16 - 18:49
 */
@Data
public class Role implements Serializable {
    private Integer roleId;
    private String roleName;
    private String roleDesc;

    private List<User> users;
}
