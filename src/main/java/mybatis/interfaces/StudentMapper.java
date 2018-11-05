package mybatis.interfaces;

import mybatis.myDao.Student;

import java.util.List;

public interface StudentMapper {
    /**
     *
     *  通过动态SQL查询
     *
     * @param student
     * @return
     */
    public List<Student> findStudentByDynamicSQL(Student student);


}
