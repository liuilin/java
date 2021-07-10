package com.imugen.service;

/**
 * @author Daniel Liu 2020/3/1 8:13
 */
public interface IAccountService {
    void transfer(String form, String target, double money);
}
