package untils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by tianyunchen on 11/19/16.
 */

public  class SharedPreferenceUtils {
    private static  final String SHARE_NAME = "userdata";


    public static  void inputPid(Context context,int pid){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_NAME, Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("pid",pid);
            editor.commit();


    }

    public static  int getPid(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_NAME, Activity.MODE_PRIVATE);
        int pid = sharedPreferences.getInt("pid",0);
        return pid;
    }
}
