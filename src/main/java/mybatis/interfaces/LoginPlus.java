package mybatis.interfaces;

import mybatis.myDao.LoginUser;
import mybatis.myDao.LoginUserPlus;

public interface LoginPlus {
    /**
     *
     *  设置返回的resultMap 不是resultType自动封装
     * @param username
     * @return
     */
    public LoginUser getLoginUserByUserName(String username);

    /**
     *    通过id查找用户登录名,密码和信息
     * @param id
     * @return
     */
    public LoginUserPlus getLoginUserAndInfoById(Integer id);

}
