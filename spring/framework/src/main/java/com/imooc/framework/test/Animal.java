package com.imooc.framework.test;

/**
 * @author Daniel Liu 2020/2/18 16:02
 */
public abstract class Animal {
    abstract void eat();

    static void eat(Animal a) {
        a.eat();
    }

    static class InnerClass {
        public static void main(String[] args) {
//            Animal a = new Cat();
//            a.eat();

//            Animal animal = new Animal() {
//                @Override
//                void eat() {
//                    System.out.println("eat shit");
//                }
//            };
//            animal.eat();

//            eat(new Animal() {
//                @Override
//                void eat() {
//                    System.out.println("eat eat");
//                }
//            });

        }
    }
}