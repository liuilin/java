package com.imooc.framework.classFiledTest;

import cn.hutool.core.lang.Console;

/**
 * @author Daniel Liu 2020/2/18 17:12
 */
public class Role {
    private String id;

    private String name;

    private Weapon weapon;
    private Armor armor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void attack() {
//        System.out.println("use "+weapon.getName()+"attack"+weapon.getAttackPower());
        Console.log("use {} weapon attack {} value", weapon.getName(), weapon.getAttackPower());
    }

    public void defense() {
//        System.out.println("use " + armor.getName() + "defense" + armor.getArmorValue());
        Console.log("use {} armor defense {} value", armor.getName(), armor.getArmorValue());
    }
}