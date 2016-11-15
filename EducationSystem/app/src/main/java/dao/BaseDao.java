package dao;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import listen.DaoListener;
import untils.Contants;
import untils.HttpUtils;

/**
 * Created by tianyun chen on 2016/9/13.
 */
public abstract class BaseDao implements Runnable,Handler.Callback {

    private DaoListener daoListener;
    private Thread thread;
    private Handler handler;
    private HttpUtils httpUtils;
    private InputStream inputStream;
    private String content;
    private JSONObject resultJson;
    public BaseDao(){
        Log.d("BaseDao","create");
       setHandler(new Handler(this));
    }
    public abstract String getAcionName();
    public abstract String getTAG();
    protected abstract  void dealWithJson(JSONObject jsonObject) throws JSONException;

    protected void  loadData(Map<String,String> paramers){

        paramers.put("timestamp","1234");
        paramers.put("sign","1234");
        thread = new Thread(this);
        httpUtils = new HttpUtils(Contants.TEST_URL,getAcionName());
        httpUtils.loadData(paramers);
        Log.d(getTAG(),"the url is:"+getAcionName());
        thread.start();
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void setDaoListener(DaoListener daoListener) {
        this.daoListener = daoListener;
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what){
            case 0:
                Log.d(getTAG(),"Handler 0");
                loadfailed();
                break;
            case 1:
                Log.d(getTAG(),"Handle 1");
                try {
                    dealWithJson(resultJson);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                loadsucessful();
        }
        return false;
    }
    @Override
    public void run() {
        Message message = new Message();
         inputStream = httpUtils.excusePost();
        if(inputStream!=null){
            message.what=1;
            content = encodeStream(inputStream);
            try {
                resultJson = new JSONObject(content);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.d(getTAG(),"the content is: "+content);
        }else
        {
            message.what=0;
            Log.d(getTAG(),"faild");
        }
        if(handler!=null){
            handler.sendMessage(message);
        }
    }

    private String encodeStream(InputStream inputStream){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len =0;
        String result = "";
        try {
            while((len=inputStream.read(data))!=-1){
                data.toString();
                outputStream.write(data,0,len);
            }
            result = new String(outputStream.toByteArray(),"UTF-8");
            Log.d("Http",result);

            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }
    }

    private void loadsucessful(){
        if(daoListener!=null){
            daoListener.onDataLoaded(this);
        }
    }
    private void loadfailed(){
        if(daoListener!=null){
            daoListener.onDataFailed(this);
        }
    }
}
