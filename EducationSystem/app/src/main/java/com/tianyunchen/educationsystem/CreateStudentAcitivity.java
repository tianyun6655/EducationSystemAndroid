package com.tianyunchen.educationsystem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import dao.BaseDao;
import dao.GetClassByTokenDao;
import listen.DaoListener;

/**
 * Created by tianyun chen on 2016/11/1.
 */
public class CreateStudentAcitivity extends BaseActivity implements DaoListener{
    private ImageView imgToken;
    private AlertDialog tokenDialog;
    private View alertView;
    private Button btn_dilog_comfire;
    private EditText edit_dilog;
    private GetClassByTokenDao getClassByTokenDao;
    private TextView edit_school;
    private TextView edit_class;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_student);
        initViews();
        bandLinstener();

    }

    @Override
    public void initViews() {
        imgToken =(ImageView)findViewById(R.id.img_token);
        tokenDialog = new AlertDialog.Builder(this).create();
        alertView = LayoutInflater.from(this).inflate(R.layout.alert_token_view,null,false);
        btn_dilog_comfire = (Button)alertView.findViewById(R.id.btn_dilog_comfire);
        edit_dilog =(EditText)alertView.findViewById(R.id.edt_token);
        edit_school = (TextView) findViewById(R.id.edt_school);
        edit_class =(TextView) findViewById(R.id.edt_class);



    }

    public void bandLinstener(){
         imgToken.setOnClickListener(this);
         btn_dilog_comfire.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
                int id = view.getId();
        if(id ==imgToken.getId()){
            tokenDialog.setView(alertView);
            tokenDialog.show();
            WindowManager.LayoutParams lp = tokenDialog.getWindow().getAttributes();
            lp.height=500;
            tokenDialog.getWindow().setAttributes(lp);
        }else if(id ==btn_dilog_comfire.getId()){
            getClassByTokenDao = new GetClassByTokenDao();
            getClassByTokenDao.setDaoListener(this);
            getClassByTokenDao.setToken(edit_dilog.getText().toString());

        }
    }

    @Override
    public void onDataLoaded(BaseDao dao) {
              if(dao.equals(getClassByTokenDao)){
                  edit_school.setText(getClassByTokenDao.getClassAndSchool().getName());
                  edit_class.setText(getClassByTokenDao.getClassAndSchool().getGrade()+"年"+getClassByTokenDao.getClassAndSchool().getNo()+"班");
                  tokenDialog.dismiss();
              }
    }

    @Override
    public void onDataFailed(BaseDao dao) {

    }
}
