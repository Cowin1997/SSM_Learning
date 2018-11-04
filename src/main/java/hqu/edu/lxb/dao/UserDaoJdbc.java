package hqu.edu.lxb.dao;

import org.springframework.stereotype.Repository;

@Repository("userDaoJdbc")
public class UserDaoJdbc implements IUserDao {
    @Override
    public void loginUser() {
        System.out.println("login by UserDaoJdbc");
    }
}
