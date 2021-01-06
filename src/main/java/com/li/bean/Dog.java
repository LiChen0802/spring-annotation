package com.li.bean;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {
    public Dog() {
        System.out.println("Dog Constructor......");
    }

    //在对象创建完成并且赋值后 调用此方法
    @PostConstruct
    public void init(){
        System.out.println("Dog.....PostConstruct");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Dog.....PreDestroy");
    }
}
