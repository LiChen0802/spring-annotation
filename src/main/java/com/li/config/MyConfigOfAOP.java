package com.li.config;

import com.li.bean.LogAspects;
import com.li.bean.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP : 【动态代理】
 *      在程序运行期间动态的将某段代码切入到指定方法的指定位置中进行运行的编程方式
 *定义通知方法:
 *          前置通知 (@Before)         :目标方法运行前运行
 *          后置通知 (@After)          :目标方法运行后运行 不论方法是正常结束还是异常结束
 *          返回通知 (@AfterReturning) :目标正常返回之后运行
 *          异常通知 (@AfterThrowing)  :目标方法抛出异常时
 *          环绕通知 (@Around)         :动态代理(最底层) ，
 *  给切面类的方法上加注解
 *
 *  需将切面类和被切类都加到容器中  在切面类上加 @Aspect 告诉Spring容器当前类时切面类
 *                              并在配置类上添加 @EnableAspectJAutoProxy 【开启基于注解的AOP模式】
 *
 *  三步 :
 *      1),业务逻辑和切面类都放入Spring容器中 并告诉Spring哪一个切面类 (@Aspect)
 *      2),在切面类的每一个通知方法上标注通知注解 告诉Spring何时运行（切入点表达式 自定义切入点 @PointCut ）
 *      3),开启基于注解的AOP模式  (@EnableAspectJAutoProxy)
 */
@EnableAspectJAutoProxy  //开启基于注解的AOP模式
@Configuration
public class MyConfigOfAOP {
    //业务逻辑类 加入容器中
    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }

    //切面类 加入容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
