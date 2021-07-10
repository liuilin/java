package com.imooc.framework.classFiledTest;

/**
 * @author Daniel Liu 2020/2/18 17:14
 */
public class Armor {
    private String name;

    private Integer armorValue;

    public Armor(String name, Integer armorValue) {
        this.name = name;
        this.armorValue = armorValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArmorValue() {
        return armorValue;
    }

    public void setArmorValue(Integer armorValue) {
        this.armorValue = armorValue;
    }
}