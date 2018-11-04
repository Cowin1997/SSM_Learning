package hqu.edu.lxb.beanfactory;

import hqu.edu.lxb.dao.UserDaoJdbc;
import hqu.edu.lxb.ioc.UserDao;

public class UserDaoFactory {
    public UserDaoFactory(){
        System.out.println("UserDaoFactory 构造器 。。。");
    }
    public UserDaoJdbc CreateUserDaoJdbc(){
        return new UserDaoJdbc();
    }
}
