package spring.Aop.proxy.test;

import hqu.edu.lxb.entity.User;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import spring.Aop.proxy.JDKProxy.JDKProxy;
import spring.Aop.proxy.entity.UserDao;
import spring.Aop.proxy.entity.UserDaoImpl;

public class test  {
    public static void main(String [] args){
        // 创建代理对象
        JDKProxy proxy = new JDKProxy();
        // 创建目标对象
        UserDao userDao = new UserDaoImpl();
        // 获得代理对象返回的增强对象
        UserDao userDao1 = (UserDao)proxy.createProxy(userDao);
        userDao1.addUser();
        userDao1.deleteUser();

    }


}
