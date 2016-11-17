package bean;

/**
 * Created by tianyunchen on 11/17/16.
 */

public class StudentListItem {
    private int stid;
    private String schoolName;
    private int grade;
    private int no;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getStid() {
        return stid;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public int getGrade() {
        return grade;
    }

    public int getNo() {
        return no;
    }
}
