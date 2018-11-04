package hqu.edu.lxb.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "userDaoMyBatis")
public class UserDaoMybatis implements IUserDao {
    @Override
    public void loginUser() {
        System.out.println("login by UserDaoMybatis");
    }
}
