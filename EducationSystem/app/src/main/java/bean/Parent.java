package bean;

/**
 * Created by tianyun chen on 2016/11/5.
 */
public class Parent {
    private int pid;
    private String name;
    private String password;
    private String mobile;
    private int sex;
    private int aid;


    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public int getSex() {
        return sex;
    }

    public int getAid() {
        return aid;
    }
}
