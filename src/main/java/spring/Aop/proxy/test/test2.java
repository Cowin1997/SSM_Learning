package spring.Aop.proxy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.Aop.proxy.entity.UserDao;

public class test2 {
    public static void main(String []args){
        String path = "proxy\\applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        UserDao userDao = (UserDao) applicationContext.getBean("userDaoProxy");
        userDao.addUser();
        userDao.deleteUser();
}
}
