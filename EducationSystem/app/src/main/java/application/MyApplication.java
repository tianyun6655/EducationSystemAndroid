package application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushManager;

/**
 * Created by tianyun chen on 2016/11/15.
 */
public class MyApplication extends Application {
    private static final String TAG = "Init";

    @Override
    public void onCreate() {
        super.onCreate();
        initChannel();
    }


    private void initChannel(){
        XGPushManager.registerPush(getApplicationContext(),"Arvin1");
    }
}
