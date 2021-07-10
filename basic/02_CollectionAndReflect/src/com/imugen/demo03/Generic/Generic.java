package com.imugen.demo03.Generic;

/**
 * @author Daniel Liu 2020/2/19 18:00
 */
public class Generic<E> {
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}