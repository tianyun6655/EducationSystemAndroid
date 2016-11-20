package bean;

/**
 * Created by tianyunchen on 11/19/16.
 */

public class Student {
    private int stid;
    private String name;
    private int studentId;
    private String birthday;
    private int cid;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStid() {
        return stid;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }
}
