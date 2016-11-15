package dao;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import bean.Class;

/**
 * Created by tianyun chen on 2016/11/2.
 */
public class GetClassDao extends BaseDao {
    private String actionName = "/class/list";
    private final String TAG ="GetClassDao";
    private ArrayList<Class> classes;
    @Override
    public String getAcionName() {
        return actionName;
    }

    public void setData(int sid){
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("sid",sid+"");
        loadData(hashMap);
    }
    @Override
    public String getTAG() {
        return TAG;
    }

    @Override
    protected void dealWithJson(JSONObject jsonObject) throws JSONException {
        classes = new ArrayList<Class>();
        Log.d("TestJson",jsonObject.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for(int i =0;i<jsonArray.length();i++){
            Class eachClass = new Class();
            eachClass.setGrade(jsonArray.getJSONObject(i).getInt("grade"));
            eachClass.setNo(jsonArray.getJSONObject(i).getInt("no"));
            eachClass.setCid(jsonArray.getJSONObject(i).getInt("cid"));
            classes.add(eachClass);
        }
    }

    public ArrayList<Class> getDatas(){
        return  classes;
    }
}
