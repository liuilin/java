package com.imugen.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库连接配置信息
 *
 * @author Daniel Liu 2020/2/12 7:27
 */
public class Configuration {
    private String Driver;
    private String Url;
    private String Username;
    private String Password;
    //先new，否则put时会空指针
    private Map<String, Mapper> mappers = new HashMap<>();

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);
    }
}