package com.tianyunchen.educationsystem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import adapter.MenuListAdapter;
import fragment.ErrorFragment;
import fragment.StudentInfromationFragment;

import android.support.v4.app.*;
import android.widget.ListView;

/**
 * Created by tianyun chen on 2016/10/31.
 */
public class StudentInformationActivity extends BaseActivity {
    private ListView menu_list;
    private  View headView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        initViews();
        initFragment();
    }

    @Override
    public void initViews() {
          menu_list=(ListView)findViewById(R.id.menu_list);
          menu_list.setAdapter(new MenuListAdapter(this));
          headView = LayoutInflater.from(this).inflate(R.layout.view_user_header,menu_list,false);
          menu_list.addHeaderView(headView);
    }

    @Override
    public void onClick(View view) {

    }


    private void initFragment(){
     //   ErrorFragment errorFragment = new ErrorFragment();
        StudentInfromationFragment studentInfromationFragment = new StudentInfromationFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content,studentInfromationFragment).commit();
    }
}
