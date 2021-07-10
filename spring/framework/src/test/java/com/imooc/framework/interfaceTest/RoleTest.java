package com.imooc.framework.interfaceTest;

import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;

/**
 * @author Daniel Liu 2020/2/18 18:10
 */
class RoleTest {

    @Test
    void magicProcess() {
        Role role = new Role();
        role.setMagicSkill(() -> Console.log("fuck..."));
        role.magicProcess();
        role.setMagicSkill(()->Console.log("shit..."));
        role.magicProcess();
    }
}