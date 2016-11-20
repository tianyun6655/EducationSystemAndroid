package dao;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import bean.Student;

/**
 * Created by tianyunchen on 11/17/16.
 */

public class GetStudentByStidDao extends BaseDao {
    private final String TAG = "getStudentBystidDao";
    private String actionName = "student/getStudentbyStid";
    private Student student;
    @Override
    public String getAcionName() {
        return actionName;
    }

    @Override
    public String getTAG() {
        return TAG;
    }

    public void setStid(int stid){
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("stid",stid+"");
        loadData(hashMap);

    }

    @Override
    protected void dealWithJson(JSONObject jsonObject) throws JSONException {
        Log.d(TAG,jsonObject.toString());

        int resultCode = jsonObject.getInt("code");
        if(resultCode!=-1){
            student = new Student();
            JSONObject data = jsonObject.getJSONObject("data");
            student.setStudentId(data.getInt("studentId"));
            student.setName(data.getString("name"));
            student.setBirthday(data.getString("birthday"));
            student.setCid(data.getInt("cid"));
        }else {
            student = null;
        }

    }

    public Student getStudent(){
        return  student;
    }
}
