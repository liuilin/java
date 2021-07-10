package com.imooc.framework.interfaceTest;

import cn.hutool.core.lang.Console;

/**
 * @author Daniel Liu 2020/2/18 18:03
 */
public class Role {
    private MagicSkill magicSkill;

//    public Role(MagicSkill magicSkill) {
//        this.magicSkill = magicSkill;
//    }


    public void setMagicSkill(MagicSkill magicSkill) {
        this.magicSkill = magicSkill;
    }

    public void magicProcess(){
        Console.log("attack start");
        magicSkill.magicAttack();
        Console.log("attack fanish");
    }
}