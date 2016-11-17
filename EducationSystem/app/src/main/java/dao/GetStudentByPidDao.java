package dao;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import bean.StudentListItem;

/**
 * Created by tianyunchen on 11/17/16.
 */

public class GetStudentByPidDao extends BaseDao {
    private final  String  TAG="GetStudentByPidDao";
    private String actionName = "student/getStduentListByPid";
    private ArrayList<StudentListItem> students;

    @Override
    public String getAcionName() {
        return actionName;
    }

    public void setPid(int pid){
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("pid",pid+"");
        loadData(hashMap);
    }

    @Override
    public String getTAG() {
        return TAG;
    }

    @Override
    protected void dealWithJson(JSONObject jsonObject) throws JSONException {
        int code  =jsonObject.getInt("code");
        if(code==0||code==-1){
            students=null;
        }else{
            students = new ArrayList<StudentListItem>() ;
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for(int i=0;i<jsonArray.length();i++){
                StudentListItem singleStudnet  = new StudentListItem();
                singleStudnet.setGrade(jsonArray.getJSONObject(i).getInt("grade"));
                singleStudnet.setSchoolName(jsonArray.getJSONObject(i).getString("schoolName"));
                singleStudnet.setNo(jsonArray.getJSONObject(i).getInt("no"));
                singleStudnet.setStid(jsonArray.getJSONObject(i).getInt("stid"));
                singleStudnet.setName(jsonArray.getJSONObject(i).getString("name"));
                students.add(singleStudnet);
            }
        }

    }


    public ArrayList<StudentListItem> getStudents(){
        return students;
    }
}
