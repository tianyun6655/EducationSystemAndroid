package dao;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import bean.Parent;
import bean.Teacher;

/**
 * Created by tianyunchen on 11/20/16.
 */

public class GetNumberByCidDao extends BaseDao {
    private String actionName="class/getNumbersFromCid";
    private final String TAG="GetNumberByCidDao";
    private ArrayList<Parent> parents;
    private ArrayList<Teacher> teachers;
    @Override
    public String getAcionName() {
        return actionName;
    }

    @Override
    public String getTAG() {
        return TAG;
    }

    public  void setCid(int cid){
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("cid",cid+"");
        loadData(hashMap);

    }
    @Override
    protected void dealWithJson(JSONObject jsonObject) throws JSONException {
        Log.d(TAG,jsonObject.toString());
        JSONObject parent = jsonObject.getJSONArray("data").getJSONObject(0);
        JSONArray parentArray = parent.getJSONArray("parent");
        parents = new ArrayList<Parent>();
        for(int i=0;i<parentArray.length();i++){
            Parent eachParent = new Parent();
            eachParent.setName(parentArray.getJSONObject(i).getString("name"));
            eachParent.setPid(parentArray.getJSONObject(i).getInt("pid"));
            parents.add(eachParent);
        }
        JSONObject teacher = jsonObject.getJSONArray("data").getJSONObject(1);
        JSONArray teacherArray = teacher.getJSONArray("teacher");

        teachers = new ArrayList<Teacher>();
        for(int i=0;i<teacherArray.length();i++){
            Teacher eachTeacher = new Teacher();
            eachTeacher.setName(teacherArray.getJSONObject(i).getString("name"));
            eachTeacher.setTid(teacherArray.getJSONObject(i).getInt("tid"));
            teachers.add(eachTeacher);
        }

    }

    public ArrayList<Parent> getParents() {
        return parents;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }
}
