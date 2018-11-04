package spring.Aop.proxy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.Aop.Config;
import spring.Aop.proxy.entity.UserDao;

import static org.junit.Assert.assertNotNull;
@ContextConfiguration(classes = Config.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class test_by_componentScan {
    @Autowired
    private UserDao userDao;

    @Test
    public void test(){
        assertNotNull(this.userDao);
    }

}
