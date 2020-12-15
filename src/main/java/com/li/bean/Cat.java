package com.li.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
        System.out.println("Cat Constructor......");
    }
    //初始化方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat afterPropertiesSet......");
    }
    //销毁方法
    @Override
    public void destroy() throws Exception {
        System.out.println("Cat.....PreDestroy");
    }

}
