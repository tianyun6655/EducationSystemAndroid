package com.tianyunchen.educationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import dao.BaseDao;
import dao.ParentLoginDao;
import dao.SignUpParentDao;
import dao.TeacherLoginDao;
import listen.DaoListener;

public class MainActivity extends BaseActivity implements DaoListener{
    private Button btn_signUp;
    private Button btn_login;
    private RadioGroup radioGroup;
    private TeacherLoginDao teacherLoginDao;
    private ParentLoginDao parentLoginDao;
    private RadioButton rbtn_teacher;
    private RadioButton rbtn_parent;
    private EditText edit_mobile;
    private  EditText edit_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initDao();
        bindLisenter();
    }

    @Override
    public void initViews() {
        btn_signUp = (Button)findViewById(R.id.btn_sign_up);
        btn_login = (Button)findViewById(R.id.btn_login);
        radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        rbtn_parent = (RadioButton)findViewById(R.id.parent_check);
        rbtn_teacher = (RadioButton)findViewById(R.id.teacher_check);
        edit_mobile  =(EditText)findViewById(R.id.edt_mobile);
        edit_password=(EditText)findViewById(R.id.edt_password);
    }

    public  void initDao(){
        teacherLoginDao = new TeacherLoginDao();
        teacherLoginDao.setDaoListener(this);
        parentLoginDao = new ParentLoginDao();
        parentLoginDao.setDaoListener(this);
    }
  private void bindLisenter(){
      btn_signUp.setOnClickListener(this);
      btn_login.setOnClickListener(this);
  }
    @Override
    public void onClick(View view) {
        int  id =view.getId();
        if(id == btn_signUp.getId()){
            Intent intent = new Intent(this,SignUpActivity.class);
            startActivity(intent);
        }else  if(id ==btn_login.getId()){
            if(radioGroup.getCheckedRadioButtonId()==rbtn_teacher.getId()){
                teacherLoginDao.setDatas(edit_mobile.getText().toString(),edit_password.getText().toString());
            }else if(radioGroup.getCheckedRadioButtonId()==rbtn_parent.getId()){
                 parentLoginDao.setParent(edit_mobile.getText().toString(),edit_password.getText().toString());

            }
        }
    }

    @Override
    public void onDataLoaded(BaseDao dao) {
          if(dao.equals(teacherLoginDao)){
              if(teacherLoginDao.getTeacher()==null){
                  Toast.makeText(MainActivity.this,"对不起，手机号码或者密码不正确",Toast.LENGTH_LONG).show();
              }else{
                  Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();

              }
          }else if (dao.equals(parentLoginDao)){
              if(parentLoginDao.getParent()==null){
                  Toast.makeText(MainActivity.this,"对不起，手机号码或者密码不正确",Toast.LENGTH_LONG).show();
              }else{
                  Intent intent = new Intent(this,StudentInformationActivity.class);
                  Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                  startActivity(intent);
              }
          }
    }

    @Override
    public void onDataFailed(BaseDao dao) {

    }

}

