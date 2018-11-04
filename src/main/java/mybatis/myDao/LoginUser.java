package mybatis.myDao;


import org.apache.ibatis.type.Alias;



@Alias("Login")
public class LoginUser {
    private String username;
    private String password;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LoginUser(){
    }

    /**
     *     有参构造器, 写有参数构造器必须写无参构造器,不然很对框架无法工作(基于反射)
     * @param username
     * @param password
     */
    public LoginUser(String username,String password){
        this.password=password;
        this.username=username;
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

    @Override
    public String toString() {
        return "LoginUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
