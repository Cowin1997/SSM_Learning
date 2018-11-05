package mybatis.myDao;

public class Student {
    private Integer sNo;
    private String sName;
    private Integer sGrade;
    private String sCo;
    private Integer sNum;
    private String sEmail;
    private Boolean sSex;

    public Integer getsNo() {
        return sNo;
    }

    public void setsNo(Integer sNo) {
        this.sNo = sNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getsGrade() {
        return sGrade;
    }

    public void setsGrade(Integer sGrade) {
        this.sGrade = sGrade;
    }

    public String getsCo() {
        return sCo;
    }

    public void setsCo(String sCo) {
        this.sCo = sCo;
    }

    public Integer getsNum() {
        return sNum;
    }

    public void setsNum(Integer sNum) {
        this.sNum = sNum;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public Boolean getsSex() {
        return sSex;
    }

    public void setsSex(Boolean sSex) {
        this.sSex = sSex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sNo=" + sNo +
                ", sName='" + sName + '\'' +
                ", sGrade=" + sGrade +
                ", sCo='" + sCo + '\'' +
                ", sNum=" + sNum +
                ", sEmail='" + sEmail + '\'' +
                ", sSex=" + sSex +
                '}';
    }
    public Student(){

    }

    public Student(Integer sNo, String sName, Integer sGrade, String sCo, Integer sNum, String sEmail, Boolean sSex) {
        this.sNo = sNo;
        this.sName = sName;
        this.sGrade = sGrade;
        this.sCo = sCo;
        this.sNum = sNum;
        this.sEmail = sEmail;
        this.sSex = sSex;
    }
}
