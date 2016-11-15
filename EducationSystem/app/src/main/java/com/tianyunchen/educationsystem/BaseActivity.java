package com.tianyunchen.educationsystem;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by tianyun chen on 2016/10/19.
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {
    private TextView textView;


    public  abstract  void initViews();


    public void setTitleTest(String title){

    }

    public void setTitleSize(float size){
    }

}