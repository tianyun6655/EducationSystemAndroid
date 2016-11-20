package dao;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import bean.Announcement;

/**
 * Created by tianyun chen on 2016/11/15.
 */
public class GetAnnouncementByClassDao extends BaseDao {
    private  final  String actionName = "announcement/listbyclass";
    private final String TAG ="AnnouncenmentByClassDao";
    private ArrayList<Announcement> announcements;
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
           int resultCode  = jsonObject.getInt("code");
         if(resultCode==1){
             JSONArray datas = jsonObject.getJSONArray("data");
             announcements = new ArrayList<Announcement>();
             for(int i=0;i<datas.length();i++){
                 JSONObject eachAnnouncement = datas.getJSONObject(i);
                 Announcement announcement = new Announcement();
                 announcement.setTitle(eachAnnouncement.getString("title"));
                 announcement.setContent(eachAnnouncement.getString("content"));
                 announcement.setDate(eachAnnouncement.getString("date"));
                 announcements.add(announcement);
             }

         }
    }


    public ArrayList<Announcement> getAnnouncements() {
        return announcements;
    }
}
