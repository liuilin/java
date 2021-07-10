package com.imooc.framework.entity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Daniel Liu 2020/2/16 14:28
 */
@Component("person1")
public class Person {
    @Value( "Mugen" )
    private String name;

    @Value( "20" )
    private Integer age;

//    @Qualifier( "bird" )
//    @Autowired
//    private Pet pet;

    private Pet pet;

    public Person(@Qualifier( "bird" ) Pet pet) {
        this.pet = pet;
    }

    public void call() {
        pet.move();
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}