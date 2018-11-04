package mybatis.myDao;

public class LoginUserPlus {
    private String username;
    private String password;
    private Integer id;
    private LoginUserInfo loginUserInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginUserInfo getLoginUserInfo() {
        return loginUserInfo;
    }

    public void setLoginUserInfo(LoginUserInfo loginUserInfo) {
        this.loginUserInfo = loginUserInfo;
    }

    @Override
    public String toString() {
        return "LoginUserPlus{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", loginUserInfo=" + loginUserInfo +
                '}';
    }
}
