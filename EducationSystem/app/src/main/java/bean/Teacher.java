package bean;

/**
 * Created by tianyun chen on 2016/11/5.
 */
public class Teacher  {
    private int tid;
    private String mobile;
    private String password;
    private String name;

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTid() {
        return tid;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }


}
