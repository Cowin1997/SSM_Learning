package springMvc.enity;

public class UserLogin {
    private String userName;
    private String passWord;
    private UserInfo userInfo;

    public UserLogin(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
    public UserLogin(){}

    public UserLogin(String userName, String passWord, UserInfo userInfo) {
        this.userName = userName;
        this.passWord = passWord;
        this.userInfo = userInfo;
    }

    public String getUserName() {
        return userName;

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
