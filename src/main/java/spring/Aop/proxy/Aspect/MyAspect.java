package spring.Aop.proxy.Aspect;


import org.springframework.stereotype.Component;


public class MyAspect {
    public void Check_Permission(){
        System.out.println("执行权限检查");
    }
    public void log(){
        System.out.println("输出日志");
    }
}
