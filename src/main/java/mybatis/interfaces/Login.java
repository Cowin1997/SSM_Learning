package mybatis.interfaces;

import mybatis.myDao.LoginUser;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface Login {
    @Select("select * from user where username = #{username}")
//    public LoginUser getUserByName(@Param("username") String username);
//    @Select("select * from user where username = #{username}")
    public LoginUser findUserByUserName(String username);

    /**
     *      Mybatis 允许增删改直接定义以下类型的返回值
     *      Integer,Long,Boolean
     *      直接在接口的方法上返回值修改,无需修改mapper映射文件
     *
     *      例如 public Boolean updateLoginUser
     *
     *
     * @param loginUser
     */
    public void addLoginUser(LoginUser loginUser);

//    public void updateLoginUser(LoginUser loginUser);
    public boolean updateLoginUser(LoginUser loginUser);


    public void deleteLoginUserByUserName(String username);

    public LoginUser findUserByUserNameAndPassWordByMap(Map<String, String> map);

    public LoginUser findUserByUserNameAndPassWord(@Param("username")String username,@Param("password")String password);

    /**
     *  通过模糊查询用户名,返回一个LoginUser的集合
     * @param  username
     * @return List
     * @auth lxb
     */
    public List<LoginUser> findUserByUserNameLike(String username);


    /**
     *  通过查询用户名,返回一个Map的集合,包含一条记录
     * @param  username
     * @return List
     * @auth lxb
     */

    public Map<String,Object> findUserByUserNameReturnMap(String username);

    /**
     *  通过模糊查询用户名,返回一个Map的集合,包含多条记录
     * @param  username
     * @return List
     * @auth lxb
     */
    @MapKey("username")
    public Map<String,Object> findUserByUserNameLikeReturnMaps(String username);


}
