package dao;

import android.nfc.Tag;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import bean.ClassAndSchool;

/**
 * Created by tianyun chen on 2016/11/6.
 */
public class GetClassByTokenDao extends BaseDao {
    private String actionName = "class/getClassByToken";
    private final String  TAG="getClassByTokenDao";
    private ClassAndSchool classAndSchool;
    @Override
    public String getAcionName() {
        return actionName;
    }

    @Override
    public String getTAG() {
        return TAG;
    }
   public void setToken(String token){
       HashMap<String,String> hashMap = new HashMap<String, String>();
       hashMap.put("token",token);
       loadData(hashMap);
   }
    @Override
    protected void dealWithJson(JSONObject jsonObject) throws JSONException {
        int result = jsonObject.getInt("code");
        if(result==0){
            classAndSchool=null;
        }else{
            JSONObject data = jsonObject.getJSONObject("data");
            classAndSchool = new ClassAndSchool();
            classAndSchool.setGrade(data.getInt("grade"));
            classAndSchool.setName(data.getString("name"));
            classAndSchool.setNo(data.getInt("no"));

        }
    }


    public ClassAndSchool getClassAndSchool(){
        return classAndSchool;
    }
}
