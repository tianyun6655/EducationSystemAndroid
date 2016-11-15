package dao;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by tianyun chen on 2016/11/3.
 */
public class SignUpAsTeacherDao extends BaseDao {
    private final String TAG="signUpAsTeacher";
    private String actionName="sys/sign_as_teacher";

    @Override
    public String getAcionName() {
        return actionName;
    }

    @Override
    public String getTAG() {
        return TAG;
    }

    public void setData(String name,String password,String mobile,String classInformation){
        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("name",name);
        hashMap.put("mobile",mobile);
        hashMap.put("password",password);
        hashMap.put("class",classInformation);
        loadData(hashMap);
    }

    @Override
    protected void dealWithJson(JSONObject jsonObject) throws JSONException {
        Log.d(TAG,jsonObject.toString());
    }
}
