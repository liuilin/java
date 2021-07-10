package com.imooc.framework.classFiledTest;

import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Daniel Liu 2020/2/18 17:28
 */
class ArmorTest {

    @Test
    void t1() {
        Weapon weapon = new Weapon("砍刀", 1000);
        Armor armor = new Armor("三级甲", 2000);
        Role role = new Role();
        role.setWeapon(weapon);
        role.setArmor(armor);
        role.attack();
        role.defense();
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("Jin", "18");
        Console.log("{}", map);
    }
}