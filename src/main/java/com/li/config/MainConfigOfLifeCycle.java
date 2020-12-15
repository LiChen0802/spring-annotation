package com.li.config;

import com.li.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Bean 的生命周期 ：
 *      Bean创建 -> 初始化  -> 销毁
 * 管理Bean的生命周期：
 *      自定义Bean的生命周期 ，在执行到当前生命周期时 调用自定义的方法 （初始化 ，销毁）
 *
 * 构造(对象创建)：
 *      单实例 ： 在容器启动时创建对象 ，
 *      多实例 ： 在每次获取时创建对象 ，
 * 初始化 ： 对象创建完成，并赋值好，调用初始化方法
 * 销毁   ： 单实例： 容器关闭 进行销毁
 *          多实例： 容器不会对这个Bean进行管理 所以不会自动调用销毁  需要手都调用
 * 1),指定初始化和销毁方法
 *      @Bean 注解中 指定 init-method destroy-method 方法     （Car.class）
 * 2),通过让Bean 实现 InitializingBean(定义初始化逻辑)，         (Cat.class)
 *              实现 DisposableBean  (定义销毁逻辑)
 */

@ComponentScan("com.li.bean")
@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    //@Scope("prototype")
    public Car car(){
        return new Car();
    }

}
