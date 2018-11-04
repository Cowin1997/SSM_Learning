package hqu.edu.lxb.test;

import hqu.edu.lxb.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String args[]){
        // 1. 获取ApplicationContext对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        // 2. 通过 ApplicationContext对象的getBean方法获取bean
        IUserService userService = (IUserService)applicationContext.getBean("userService");
        // 3. 调用里面的方法
        userService.message();
    }
}
