package bean;

/**
 * Created by tianyun chen on 2016/11/2.
 */
public class SchoolAndAddress {

    private String schoolName;
    private String location;
    private int sid;

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSid() {
        return sid;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getLocation() {
        return location;
    }
}
