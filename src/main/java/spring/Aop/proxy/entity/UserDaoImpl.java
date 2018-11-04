package spring.Aop.proxy.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao{
    @Override
    public void addUser() {

        System.out.println("addUser....");
    }

    @Override
    public void deleteUser() {
        System.out.println("deleteUser....");
    }


    @Bean("userDao")
    public UserDao UserDaoImpl(){
        return new UserDaoImpl();
    }
}
