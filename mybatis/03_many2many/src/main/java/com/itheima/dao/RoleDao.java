package com.imugen.dao;

import com.imugen.domain.Role;

import java.util.List;

/**
 * @author Gakki
 * @date 2018/12/16 - 18:52
 */
public interface RoleDao {

    /**
     * 查询所有
     *
     * @return
     */
    List<Role> findAll();
}
