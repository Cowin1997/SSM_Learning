package hqu.edu.lxb.service;

import hqu.edu.lxb.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

// 注册为bean 名字为userService
@Service("userService")

public class UserServiceImpl implements IUserService {
    /**
     *   通过注解的方式进行自动的转配
     *    @Autowired 默认根据Type进行匹配
     *    有多个实现接口类的时候
     */
    @Autowired
    @Qualifier("userDaoMyBatis")
    private IUserDao abc;


    @Override
    public void message() {
        System.out.println("Message by UserServiceImpl");
        this.abc.loginUser();
    }

    /**
     *    通过构造器注入
     * @param userDao
     * 结果：
     *      调用构造器。。。
     *      调用set函数。。。
     *      Message by UserServiceImpl
     *      login by UserDaoMybatis
     */

    /**    如果通过set方法注入属性，那么spring会通过默认的空参构造方法来实例化对象，
     *      所以如果在类中写了一个带有参数的构造方法，一定要把空参数的构造方法写上，
     *      否则spring没有办法实例化对象，导致报错。
     *
     *
     * @param userDao
     */
//    public UserServiceImpl(IUserDao userDao){
//        System.out.println("调用构造器。。。");
//       this.userDao = userDao;
//    }

    public void setUserDao(IUserDao userDao) {
        System.out.println("调用set函数。。。");
        this.abc = userDao;
    }

    /**
     *  以上是通过 属性 setter方法注入的方式
     */
}
