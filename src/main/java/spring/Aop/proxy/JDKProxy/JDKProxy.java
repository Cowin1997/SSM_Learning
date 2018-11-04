package spring.Aop.proxy.JDKProxy;

import org.springframework.beans.factory.annotation.Autowired;
import spring.Aop.proxy.Aspect.MyAspect;
import spring.Aop.proxy.entity.UserDao;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    private UserDao userDao;

    public Object createProxy(UserDao userDao){
        this.userDao = userDao;
        // 1.类加载器
        ClassLoader classLoader = JDKProxy.class.getClassLoader();
        // 2.被代理的对象实现的所有的接口
        Class [] classes = userDao.getClass().getInterfaces();
        // 3. 使用代理类进行加强,返回代理后的对象
        return Proxy.newProxyInstance(classLoader,classes,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 1.声明切面
        MyAspect myAspect = new MyAspect();
        // 2 前增强
        myAspect.Check_Permission();
        // 3.调用目标类的目标方法,并传入参数
        Object object = method.invoke(userDao,args);
        // 4.后增强
        myAspect.log();
        return object;
    }
}
