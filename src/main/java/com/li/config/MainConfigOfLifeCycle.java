package com.li.config;

import com.li.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Bean 的生命周期 ：      <p>
 *      Bean创建 -> 初始化  -> 销毁      <p>
 * 管理Bean的生命周期：<p>
 *      自定义Bean的生命周期 ，在执行到当前生命周期时 调用自定义的方法 （初始化 ，销毁）<p>
 *
 * 构造(对象创建)：<p>
 *      单实例 ： 在容器启动时创建对象 ，<p>
 *      多实例 ： 在每次获取时创建对象 ，<p>
 * 初始化 ： 对象创建完成，并赋值好，调用初始化方法<p>
 * 销毁   ： 单实例： 容器关闭 进行销毁<p>
 *          多实例： 容器不会对这个Bean进行管理 所以不会自动调用销毁  需要手都调用<p>
 * 1),指定初始化和销毁方法<p>
 *      @Bean 注解中 指定 init-method destroy-method 方法     （Car.class）<p>
 * 2),通过让Bean 实现 InitializingBean(定义初始化逻辑)，         (Cat.class)<p>
 *              实现 DisposableBean  (定义销毁逻辑)<p>
 * 3),通过注解<p>
 *      @PostConstruct : 在Bean创建完成并且属性复制完成, 来执行这个注解标注的初始化方法<p>
 *      @PreDestroy    : 在容器销毁Bean之前通知我们进行清理工作<p>
 * 4),BeanPostProcessor接口: Bean的后置处理器 在Bean初始化前后进行处理 <p>
 *
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
