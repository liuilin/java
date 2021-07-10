package com.imooc.framework.test;

import org.junit.jupiter.api.Test;

/**
 * @author Daniel Liu 2020/2/18 16:04
 */
class AnimalTest {

    @Test
    void eat() {
        Cat cat = new Cat();
        Pig pig = new Pig();
//        cat.eat();
//        pig.eat();
        Animal.eat(pig);
    }

    @Test
    public void eat2() {
        Animal a = new Pig();

//        (Cat) a instanceof Cat ? ((Cat)a) : (Pig)a;
//        Cat instanceof a ? ((Cat) a) : (Pig) a;
        if (a instanceof Cat) {
            Cat c = (Cat) a;
            c.eat();
        } else if (a instanceof Pig) {
            Pig p = (Pig) a;
            p.eat();
        }
    }
}