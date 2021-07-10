package com.imugen.domain;

/**
 * @author Daniel Liu 2020/3/12 19:55
 */
public class User {
    private String username;

    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + ", age=" + age + '}';
    }
}