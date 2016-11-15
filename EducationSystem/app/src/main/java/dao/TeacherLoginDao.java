package dao;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import bean.Teacher;

/**
 * Created by tianyun chen on 2016/11/5.
 */
public class TeacherLoginDao extends BaseDao{
    private final String actionName="sys/login_as_teacher";
    private final String TAG="TeacberLoginDao";
    private Teacher  teacher;
    @Override
    public String getAcionName() {
        return actionName;
    }

    @Override
    public String getTAG() {
        return TAG;
    }

    public  void setDatas(String mobile,String password){
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("mobile",mobile);
        hashMap.put("password",password);
        loadData(hashMap);
    }
    @Override
    protected void dealWithJson(JSONObject jsonObject) throws JSONException {
            int result = jsonObject.getInt("code");
        Log.d(TAG,jsonObject.toString());

        if(result !=0){
            JSONObject teacherJson = jsonObject.getJSONObject("data");

            teacher = new Teacher();
            teacher.setTid(teacherJson.getInt("tid"));
            teacher.setName(teacherJson.getString("name"));
            teacher.setMobile(teacherJson.getString("mobile"));
            teacher.setPassword(teacherJson.getString("password"));

        }else {
            teacher = null;
        }
    }
    public Teacher getTeacher(){
        return  teacher;
    }
}
