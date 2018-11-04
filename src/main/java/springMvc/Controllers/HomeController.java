package springMvc.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.Aop.proxy.entity.UserDao;
//import mybatis.myDao.MyBaitsTest2;
import mybatis.myDao.MyBaitsTest2;



@Controller
public class HomeController {
    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
    public String home(){

//        MyBaitsTest2 myBaitsTest2 = new MyBaitsTest2();
        MyBaitsTest2.test();
        System.out.println("执行home方法"+Thread.currentThread().getContextClassLoader().getResource("/").getPath());
        return "inde";
    }
}
