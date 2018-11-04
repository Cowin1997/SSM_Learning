package hqu.edu.lxb.ioc;

import hqu.edu.lxb.dao.IUserDao;
import hqu.edu.lxb.dao.UserDaoJdbc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testIoc {
    public static void main(String args[]){
        // 1. 初始化spring容器,加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserDao userDao = (UserDaoJdbc) applicationContext.getBean("userDaoJdbc");
        userDao.loginUser();


    }
}
