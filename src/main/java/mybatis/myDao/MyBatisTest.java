package mybatis.myDao;

import mybatis.interfaces.Login;
import mybatis.interfaces.LoginPlus;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
//import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {



    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = org.apache.ibatis.io.Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }


    @Test
    public void findUserByUserName() throws Exception{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
           // LoginUser loginUser = sqlSession.selectOne("mybatis.mapper.LoginUser" + ".findUserByUserName", "xiaofei");
             Login login = sqlSession.getMapper(Login.class);
              LoginUser loginUser = login.findUserByUserName("xiaofei");
            System.out.println(loginUser.toString());
        }
        finally {
            sqlSession.close();
        }


    }




    @Test
    public void testadd() throws IOException {

        SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            //openSession();不会自动提交数据,需要手动提交
            sqlSession = sqlSessionFactory.openSession();



            LoginUser loginUser = new LoginUser("xiaofei","password");
            sqlSession.insert("mybatis.interfaces.Login"+".addLoginUser",loginUser);
          //  Login loginmapper = sqlSession.getMapper(Login.class);
         //   loginmapper.addLoginUser(loginUser);
            sqlSession.commit(); //手动进行提交
        }
        finally {
            sqlSession.close();
        }
    }


    @Test
    public void testupdate() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        try{

            LoginUser loginUser = new LoginUser("abc","passwordupdate");
  //          sqlSession2.update("mybatis.mapper.LoginUser"+".updateLoginUser",loginUser);
 //           int b=sqlSession2.update("mybatis.mapper.LoginUser"+".updateLoginUser",loginUser);
 //           System.out.println("影响"+b+"行");
            Login loginmapper = sqlSession2.getMapper(Login.class);
            boolean b = loginmapper.updateLoginUser(loginUser);
            System.out.println(b);
        }
        finally {
            sqlSession2.close();
        }
    }


    @Test
    public void testdelete() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 自动提交
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        try{

            String name = "abc";
            Login loginmapper = sqlSession2.getMapper(Login.class);
            loginmapper.deleteLoginUserByUserName(name);
          //  sqlSession2.update("mybatis.mapper.LoginUser"+".deleteLoginUserByUserName",loginUser);
        }
        finally {
            sqlSession2.close();
        }
    }
    @Test
    public void testTwoParams() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 自动提交
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        try {
            Login loginmapper = sqlSession2.getMapper(Login.class);
           LoginUser loginUser =loginmapper.findUserByUserNameAndPassWord("xiaofei","admin");
            System.out.println(loginUser);
        }
        finally {
            sqlSession2.close();
        }
    }

    @Test
    public void testTwoParamsByMap() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 自动提交
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        try {
            Login loginmapper = sqlSession2.getMapper(Login.class);
            Map<String,String> map = new HashMap<>();
            map.put("username","xiaofei");
            map.put("password","admin");
            LoginUser loginUser =loginmapper.findUserByUserNameAndPassWordByMap(map);
            System.out.println(loginUser);
        }
        finally {
            sqlSession2.close();
        }
    }

    @Test
    public void testReturnList() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            Login loginmapper = sqlSession.getMapper(Login.class);
            // 查询用户名包含a的所有记录
            List<LoginUser> loginUsers = loginmapper.findUserByUserNameLike("%a%");
            for (LoginUser l : loginUsers){
                System.out.println(l.toString());
            }
        }
        finally {
            sqlSession.close();
        }
    }




    @Test
    public void testReturnMap() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
           Login loginMapper = sqlSession.getMapper(Login.class);
           Map<String,Object> map = loginMapper.findUserByUserNameReturnMap("abcd");
           System.out.println(map);


        }
        finally {
            sqlSession.close();
        }
    }



    @Test
    public void testReturnMaps() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            Login loginMapper = sqlSession.getMapper(Login.class);
            Map<String,Object> map = loginMapper.findUserByUserNameLikeReturnMaps("abcd");
            System.out.println(map);

            /**
             *  结果
             *      {abcd={password=password, username=abcd}}
             *
             */
        }
        finally {
            sqlSession.close();
        }
    }


    @Test
    public void testResultMap() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            LoginPlus loginPlusMapper = sqlSession.getMapper(LoginPlus.class);
            LoginUser loginUser =loginPlusMapper.getLoginUserByUserName("xiaofei");

            System.out.println(loginUser);
            /**
             *  结果
             *      LoginUser{username='xiaofei', password='admin'}
             *
             */
        }
        finally {
            sqlSession.close();
        }
    }


    @Test
    public void testInfo() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            LoginPlus loginPlusMapper = sqlSession.getMapper(LoginPlus.class);
            LoginUserPlus loginUserPlus =loginPlusMapper.getLoginUserAndInfoById(2);
            System.out.println(loginUserPlus);

            /**
             *  结果
             *      LoginUser{username='xiaofei', password='admin'}
             *
             */
        }
        finally {
            sqlSession.close();
        }
    }
}
