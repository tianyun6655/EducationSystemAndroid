package dao;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by tianyunchen on 11/17/16.
 */

public class GetStudentByStidDao extends BaseDao {
    private final String TAG = "getStudentBystidDao";
    private String actionName = "student/getStudentbyStid";

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

    }
}
