package springMvc.enity;

public class UserInfo {
    private String address;
    private String sex;

    public UserInfo(){}
    public UserInfo(String address, String sex) {
        this.address = address;
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
