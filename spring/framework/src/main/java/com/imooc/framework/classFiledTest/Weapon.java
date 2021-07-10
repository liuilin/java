package com.imooc.framework.classFiledTest;

/**
 * @author Daniel Liu 2020/2/18 17:14
 */
public class Weapon {
    private String name;

    private Integer attackPower;

    public Weapon(String name, Integer attackPower) {
        this.name = name;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(Integer attackPower) {
        this.attackPower = attackPower;
    }
}