package mybatis.test;

import mybatis.interfaces.StudentMapper;
import mybatis.myDao.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = org.apache.ibatis.io.Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void testDynamicSQL01() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try{
            Student toFindStudent = new Student(1003,null,null,null,null,null,false);
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> list =studentMapper.findStudentByDynamicSQL(toFindStudent);
           for(Student student:list){
                System.out.println(student);
           }
        }
        finally {
            sqlSession.close();
        }
    }
}
