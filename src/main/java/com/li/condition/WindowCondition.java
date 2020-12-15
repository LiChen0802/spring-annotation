package com.li.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowCondition implements Condition {
    /**
     *
     * @param conditionContext  判断条件能使用的上下文环境
     * @param annotatedTypeMetadata 注释信息
     * @return 是否 windows 系统
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取当前的bean工厂
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //获取环境 系统参数 环境变量
        Environment environment = conditionContext.getEnvironment();
        //bean定义 注册一个bean 查询bean的定义等等
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        //获取当前class路径
        ResourceLoader resourceLoader = conditionContext.getResourceLoader();
        return false;
    }
}
