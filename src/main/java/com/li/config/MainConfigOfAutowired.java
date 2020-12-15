package com.li.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *自动装配 :
 *      Spring利用依赖注入(DI) , 完成对IOC容器中各个组件的依赖关系赋值
 * 1), @Autowire
 *
 *
 *
 */
@Configuration
@ComponentScan({"com.li.controller","com.li.dao","com.li.service"})
public class MainConfigOfAutowired {
}
