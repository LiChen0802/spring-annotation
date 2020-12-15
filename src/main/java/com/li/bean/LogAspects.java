package com.li.bean;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

//切面类
@Aspect  //告诉Spring容器当前类时切面类
public class LogAspects {
    //设定切入点
    //本类引用
    //引用其他类时 需要在执行切入点时写入全类名
    @Pointcut("execution(public int com.li.bean.MathCalculator.*(..))")
    public void pointCut() {
    }

    //指定切入点
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() + "运行。。。。。参数列表{" + Arrays.asList(args) + "}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("除法结束。。。。。参数列表{" + Arrays.asList(args) + "}");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        System.out.println("除法返回。。。。。参数列表{" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("除法异常。。。。。异常信息{" + exception + "}");
    }
}
