package dao;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import bean.Parent;

/**
 * Created by tianyun chen on 2016/11/4.
 */
public class SignUpParentDao extends BaseDao {
    private String actionName = "sys/sign_as_parent";
    private final  String TAG ="SignUpParentDao";

    private Parent parent;

    @Override
    public String getAcionName() {
        return actionName;
    }

    public void setDatas(String name,String mobile,String password){
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("name",name);
        hashMap.put("mobile",mobile);
        hashMap.put("password",password);
        loadData(hashMap);
    }
    @Override
    public String getTAG() {
        return TAG;
    }

    @Override
    protected void dealWithJson(JSONObject jsonObject) throws JSONException {
               int result = jsonObject.getInt("code");
        if(result!=0){
            JSONObject parentJsont = jsonObject.getJSONObject("data");
            parent = new Parent();
            parent.setMobile(parentJsont.getString("mobile"));
            parent.setName(parentJsont.getString("name"));
            parent.setAid(parentJsont.getInt("aid"));
            parent.setPassword(parentJsont.getString("password"));
        }else{
            parent = null;
        }

    }
    public Parent getParent(){
        return  parent;
    }
}
