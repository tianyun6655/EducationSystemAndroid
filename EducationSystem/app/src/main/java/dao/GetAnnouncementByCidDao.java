package dao;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import bean.Student;

/**
 * Created by tianyunchen on 11/20/16.
 */

public class GetAnnouncementByCidDao extends BaseDao {
    private String actionName="announcement/listbyclass";
    private final String TAG="GetAnnouncementByCidDao";
    @Override
    public String getAcionName() {
        return actionName;
    }

    @Override
    public String getTAG() {
        return TAG;
    }

    public void setCid(int cid){
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("cid",cid+"");
        loadData(hashMap);
    }
    @Override
    protected void dealWithJson(JSONObject jsonObject) throws JSONException {

    }
}
