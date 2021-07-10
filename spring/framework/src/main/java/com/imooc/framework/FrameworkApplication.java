package com.imooc.framework;

import com.imooc.framework.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FrameworkApplication {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(FrameworkApplication.class, args);
//        Person person = ac.getBean(Person.class);
        Person person = (Person) ac.getBean("person1");
//        System.out.println(person.getName());
        person.call();
    }

}
