package com.imugen.mybatis.utils;

import com.imugen.domain.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Daniel Liu 2020/2/12 8:30
 */
public class DbUtils {
    private Connection conn;
    public static Connection getConnection(Configuration cfg){
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException();
        }
    }
}