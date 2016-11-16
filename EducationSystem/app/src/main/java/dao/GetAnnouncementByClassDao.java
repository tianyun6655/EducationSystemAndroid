package dao;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by tianyun chen on 2016/11/15.
 */
public class GetAnnouncementByClassDao extends BaseDao {
    private  final  String actionName = "announcement/listbyclass";
    private final String TAG ="AnnouncenmentByClassDao";
    @Override
    public String getAcionName() {
        return actionName;
    }

    @Override
    public String getTAG() {
        return TAG;
    }

    public  void setCid(int cid){
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("cid",cid+"");
        loadData(map);
    }
    @Override
    protected void dealWithJson(JSONObject jsonObject) throws JSONException {
        Log.d(TAG,jsonObject.toString());

    }
}
