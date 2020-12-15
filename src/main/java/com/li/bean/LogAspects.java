package com.li.bean;


import org.aspectj.lang.annotation.*;

//切面类
@Aspect  //告诉Spring容器当前类时切面类
public class LogAspects {
    //设定切入点
    //本类引用
    //引用其他类时 需要在执行切入点时写入全类名
    @Pointcut("execution(public int com.li.bean.MathCalculator.*(..))")
    public void pointCut(){}

    //指定切入点
    @Before("pointCut()")
    public void logStart(){
        System.out.println("除法运行。。。。。参数列表{}");
    }

    @After("pointCut()")
    public void logEnd(){
        System.out.println("除法结束。。。。。参数列表{}");
    }

    @AfterReturning("pointCut()")
    public void logReturn(){
        System.out.println("除法返回。。。。。参数列表{}");
    }

    @AfterThrowing("pointCut()")
    public void logException(){
        System.out.println("除法异常。。。。。异常信息{}");
    }
}
