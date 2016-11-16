package application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.sdk.android.push.CloudPushService;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory;

/**
 * Created by tianyun chen on 2016/11/15.
 */
public class MyApplication extends Application {
    private static final String TAG = "Init";

    @Override
    public void onCreate() {
        super.onCreate();
        initChannle(this);
    }

    private void initChannle(Context application){
        PushServiceFactory.init(application);
        final CloudPushService pushService =PushServiceFactory.getCloudPushService();
        pushService.register(application, new CommonCallback() {
            @Override
            public void onSuccess(String s) {
                Log.d(TAG, "init cloudchannel success"+pushService.getDeviceId());

            }

            @Override
            public void onFailed(String errorCode, String errorMessage) {
                Log.d(TAG, "init cloudchannel failed -- errorcode:" + errorCode + " -- errorMessage:" + errorMessage);
            }
        });
    }
}
