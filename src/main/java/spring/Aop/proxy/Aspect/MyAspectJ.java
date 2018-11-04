package spring.Aop.proxy.Aspect;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;
public class MyAspectJ {
    // 前置通知
    public void myBefore(JoinPoint joinpoint){
        System.out.println("前置通知: 权限检查...");
        System.out.println("目标类是："+joinpoint.getTarget());
        System.out.println("增强方法是："+joinpoint.getSignature().getName());
    }
    // 后置通知
    public void myAfterReturning(JoinPoint joinpoint,Object returnVal){
        System.out.println("后置通知：函数返回后通知");
        System.out.println("增强方法是："+joinpoint.getSignature().getName());
    }
    // 环绕通知
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕通知开始...");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("环绕通知结束");
        return object;
    }
    // 异常通知
    public void myAfterThrowing(JoinPoint joinpoint,Throwable e){
        System.out.println("异常通知...");
    }
    // 最终通知
    public void MyAfter(){
        System.out.println("最终通知....");
    }
}
