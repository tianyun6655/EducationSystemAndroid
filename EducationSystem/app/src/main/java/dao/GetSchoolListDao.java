package dao;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bean.SchoolAndAddress;
import untils.Contants;

/**
 * Created by tianyun chen on 2016/11/2.
 */
public class GetSchoolListDao extends BaseDao {
    private final String TAG ="GetSchoolListDao";
    private String actionName = "school/list";
    private ArrayList<SchoolAndAddress> schoolAndAddresseslist;
    @Override
    public String getAcionName() {
        return actionName;
    }
    public void setParamer(){
        Map<String,String> paramers = new HashMap<String,String>();

        loadData(paramers);
    }
    @Override
    public String getTAG() {
        return TAG;
    }

    @Override
    protected void dealWithJson(JSONObject jsonObject) throws JSONException {
        schoolAndAddresseslist = new ArrayList<SchoolAndAddress>();
       JSONArray array =  jsonObject.getJSONArray("data");
        for(int i=0;i<array.length();i++){
            StringBuffer  location = new StringBuffer();
            SchoolAndAddress schoolAndAddress = new SchoolAndAddress();
            schoolAndAddress.setSchoolName(array.getJSONObject(i).getString("name"));
            String provice = array.getJSONObject(i).getString("province");
            String city = array.getJSONObject(i).getString("city");
            if(provice.equals(city)){
                location.append(city);
            }else{
                location.append(provice).append(city);
            }
            String qu  = array.getJSONObject(i).getString("qu");
            location.append(qu);
            String road  = array.getJSONObject(i).getString("road");
            location.append(road);
            int sid = array.getJSONObject(i).getInt("sid");
            Log.d(TAG,location.toString());
            schoolAndAddress.setSid(sid);
            schoolAndAddress.setLocation(location.toString());
            schoolAndAddresseslist.add(schoolAndAddress);
        }
    }

    public ArrayList<SchoolAndAddress> getSchoolAndAddresseslist() {
        return schoolAndAddresseslist;
    }
}
