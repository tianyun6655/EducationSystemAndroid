package dao;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by tianyunchen on 11/19/16.
 */

public class BandParentDao extends BaseDao {
    private String actionName ="student/bandParent";
    private final String TAG="BandParentDao";
    @Override
    public String getAcionName() {
        return actionName;
    }

    @Override
    public String getTAG() {
        return TAG;
    }

    public void setParamers(int stid,int pid,int cid){
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("stid",stid+"");
        hashMap.put("pid",pid+"");
        hashMap.put("cid",cid+"");
        loadData(hashMap);
    }

    @Override
    protected void dealWithJson(JSONObject jsonObject) throws JSONException {

    }
}
