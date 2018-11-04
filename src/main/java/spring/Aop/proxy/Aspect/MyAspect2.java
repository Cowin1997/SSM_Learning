package spring.Aop.proxy.Aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 *  SpringAop 运行时候织入
 *  AspectJ 编译时织入
 *
 *
 */
public class MyAspect2 implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        check_Permission();
        Object object = methodInvocation.proceed();
        log();
        return object;
    }
    public void check_Permission(){
        System.out.println("执行权限检查....");
    }
    public void log(){
        System.out.println("记录日志....");
    }
}
