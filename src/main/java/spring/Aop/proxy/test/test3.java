package spring.Aop.proxy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.Aop.proxy.entity.UserDao;

public class test3 {
    public static void main(String [] args){
        String path = "proxy\\applicationContext_AspectJ_xml.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.addUser();
    }
}
