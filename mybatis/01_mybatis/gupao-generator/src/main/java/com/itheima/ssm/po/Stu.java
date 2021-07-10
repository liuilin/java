package com.imugen.ssm.po;

public class Stu {
    private Integer id;

    private String name;

    public Stu(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Stu() {
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
}