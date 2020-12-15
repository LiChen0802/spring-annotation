package com.li.config;


import com.li.bean.Person;
import com.li.condition.LinuxCondition;
import com.li.condition.WindowCondition;
import org.springframework.context.annotation.*;


/**
 * FilterType  按照指定形式进行指定规则
 * <p>
 * ANNOTATION, 根据注解
 * ASSIGNABLE_TYPE, 根据给定的类型(.class)
 * ASPECTJ, ASPECTJ表达式
 * REGEX, 正则表达式
 * CUSTOM, 自定义规则
 */
@Configuration
@ComponentScan(value = "com.li", includeFilters = {
        @ComponentScan.Filter(
                //type = FilterType.ANNOTATION, classes = {Controller.class, Service.class}
                type = FilterType.CUSTOM, classes = {MyTypeFilter.class}
        )
}, useDefaultFilters = false)
public class MainConfig {

    //默认为单实例对象

    /**
     * Scope  : 调整类的作用域
     * prototype :设定对象为多实例 ioc容器启动时不会调用方法 创建对象放在容器中
     * 每次获取对象时才会创建对象
     * singleton : (默认值) 单实例 ioc容器启动时就会将对象放入容器中
     * 每次获取都是从容器中调取
     * request : 同一次请求 获取相同相同对象
     * session : 同一会话 获取相同相同对象
     * <p>
     * ### @Lazy 懒加载(延迟加载) : 第一次获取bean时才进行对象的创建与加载
     */
    @Scope("prototype") // 设置为单实例对象
    @Bean("person")
    public Person person() {
        return new Person("li", 18);
    }

    /**
* @Conditional : 按照一定条件进行判断 满足条件时才给容器中注册bean
     */
    @Conditional({WindowCondition.class, LinuxCondition.class})
    @Bean
    public Person person02() {
        return new Person("bill", 32);
    }

    @Bean
    public Person person03() {
        return new Person("linux", 54);
    }
}
