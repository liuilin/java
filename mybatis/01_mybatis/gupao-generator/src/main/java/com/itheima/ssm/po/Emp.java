package com.imugen.ssm.po;

import java.util.Date;

public class Emp {
    private Integer id;

    private String name;

    private String gender;

    private Double salary;

    private Date joinDate;

    private Integer deptId;

    public Emp(Integer id, String name, String gender, Double salary, Date joinDate, Integer deptId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.joinDate = joinDate;
        this.deptId = deptId;
    }

    public Emp() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}