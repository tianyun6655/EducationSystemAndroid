package dao;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import bean.Student;

/**
 * Created by tianyunchen on 11/18/16.
 */

public class GetStduentByCidDao extends BaseDao {
    private String actionName="student/getStudentBycid";
    private final String TAG="GetStudentByCidDao";
    private  ArrayList<Student> students;
    @Override
    public String getAcionName() {
        return actionName;
    }

    @Override
    public String getTAG() {
        return TAG;
    }

    public void setCid (int cid){
        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("cid",cid+"");
        loadData(hashMap);
    }

    @Override
    protected void dealWithJson(JSONObject jsonObject) throws JSONException {
        Log.d(TAG,jsonObject.toString());
        int resultCode = jsonObject.getInt("code");
        if(resultCode==0||resultCode==-1){
            students=null;
        }else{
            students = new ArrayList<Student>();
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject eachItem =jsonArray.getJSONObject(i);
                Student  student = new Student();
                student.setName(eachItem.getString("name"));
                student.setStid(eachItem.getInt("stid"));
                student.setStudentId(eachItem.getInt("studentId"));
                students.add(student);
            }
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
