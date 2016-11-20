package com.tianyunchen.educationsystem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.ClassListAdpater;
import adapter.SchoolListAdpater;
import adapter.StudentListAdapter;
import bean.Class;
import bean.SchoolAndAddress;
import bean.Student;
import dao.BandParentDao;
import dao.BaseDao;
import dao.GetClassByTokenDao;
import dao.GetClassDao;
import dao.GetSchoolListDao;
import dao.GetStduentByCidDao;
import fragment.TeacherSignUpFragment;
import listen.DaoListener;
import untils.SharedPreferenceUtils;

/**
 * Created by tianyun chen on 2016/11/1.
 */

public class CreateStudentAcitivity extends BaseActivity implements DaoListener, AdapterView.OnItemClickListener {
    private ImageView imgToken;
    private AlertDialog tokenDialog;
    private View alertView;
    private Button btn_dilog_comfire;
    private EditText edit_dilog;
    private GetClassByTokenDao getClassByTokenDao;
    private TextView edit_school;
    private TextView edit_class;
    private TextView edit_studentid;
    private GetSchoolListDao getSchoolListDao;
    private BandParentDao bandParentDao;
    private GetStduentByCidDao getStduentByCidDao;
    private GetClassDao getClassDao;
    private ListView schoolList;
    private ListView classList;
    private ListView studentList;
    private AlertDialog schoolAlert;
    private View shoolAlertView;
    private View classAlertView;
    private View studentListView;
    private AlertDialog classDialog;
    private AlertDialog studentAlert;
    private TextView edt_name;
    private Button btn_band;
    private int sid;
    private int cid;
    private int stid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_student);
        initViews();
        initDao();
        bandLinstener();

    }

    @Override
    public void initViews() {
        imgToken = (ImageView) findViewById(R.id.img_token);
        tokenDialog = new AlertDialog.Builder(this).create();
        alertView = LayoutInflater.from(this).inflate(R.layout.alert_token_view, null, false);
        btn_dilog_comfire = (Button) alertView.findViewById(R.id.btn_dilog_comfire);
        edit_dilog = (EditText) alertView.findViewById(R.id.edt_token);
        edit_school = (TextView) findViewById(R.id.edt_school);
        edit_class = (TextView) findViewById(R.id.edt_class);
        edt_name = (TextView) findViewById(R.id.edt_name);
        btn_band = (Button)findViewById(R.id.btn_band);
        edit_studentid = (TextView)findViewById(R.id.tv_studentid);
        schoolAlert = new AlertDialog.Builder(this).create();

        shoolAlertView = LayoutInflater.from(this).inflate(R.layout.alert_school_list, null);
        classAlertView = LayoutInflater.from(this).inflate(R.layout.alert_school_list, null);
        studentListView = LayoutInflater.from(this).inflate(R.layout.alert_school_list, null);

        classDialog = new AlertDialog.Builder(this).create();
        studentAlert = new AlertDialog.Builder(this).create();

    }

    public void bandLinstener() {
        imgToken.setOnClickListener(this);
        btn_dilog_comfire.setOnClickListener(this);
        edit_school.setOnClickListener(this);
        edit_class.setOnClickListener(this);
        edt_name.setOnClickListener(this);
        btn_band.setOnClickListener(this);
    }

    private void initDao() {
        getSchoolListDao = new GetSchoolListDao();
        getSchoolListDao.setDaoListener(this);
        getClassDao = new GetClassDao();
        getClassDao.setDaoListener(this);
        getStduentByCidDao = new GetStduentByCidDao();
        getStduentByCidDao.setDaoListener(this);
        bandParentDao = new BandParentDao();
        bandParentDao.setDaoListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == imgToken.getId()) {
            tokenDialog.setView(alertView);
            tokenDialog.show();
            WindowManager.LayoutParams lp = tokenDialog.getWindow().getAttributes();
            lp.height = 500;
            tokenDialog.getWindow().setAttributes(lp);
        } else if (id == btn_dilog_comfire.getId()) {
            getClassByTokenDao = new GetClassByTokenDao();
            getClassByTokenDao.setDaoListener(this);
            getClassByTokenDao.setToken(edit_dilog.getText().toString());

        } else if (id == edit_school.getId()) {
            getSchoolListDao.setParamer();
        } else if (id == edit_class.getId()) {
            getClassDao.setData(sid);
        } else if (id == edt_name.getId()) {
            getStduentByCidDao.setCid(cid);
        }else if (id ==btn_band.getId()){
            bandParentDao.setParamers(stid, SharedPreferenceUtils.getPid(this),cid);
        }
    }

    @Override
    public void onDataLoaded(BaseDao dao) {
        if (dao.equals(getClassByTokenDao)) {
            edit_school.setText(getClassByTokenDao.getClassAndSchool().getName());
            edit_class.setText(getClassByTokenDao.getClassAndSchool().getGrade() + "年" + getClassByTokenDao.getClassAndSchool().getNo() + "班");
            tokenDialog.dismiss();
        } else if (dao.equals(getSchoolListDao)) {
            schoolList = (ListView) shoolAlertView.findViewById(R.id.alert_list);
            schoolList.setAdapter(new SchoolListAdpater(this, getSchoolListDao.getSchoolAndAddresseslist()));
            schoolList.setOnItemClickListener(this);
            schoolAlert.setView(shoolAlertView);
            schoolAlert.show();
        } else if (dao.equals(getClassDao)) {
            classList = (ListView) classAlertView.findViewById(R.id.alert_list);
            classList.setAdapter(new ClassListAdpater(this, getClassDao.getDatas()));
            classList.setOnItemClickListener(this);
            classDialog.setView(classAlertView);
            classDialog.show();
        }else if(dao.equals(getStduentByCidDao)){
              studentList  = (ListView)studentListView.findViewById(R.id.alert_list);
              studentList.setAdapter(new StudentListAdapter(this,getStduentByCidDao.getStudents()));
              studentList.setOnItemClickListener(this);
            Log.d("CreateSize",getStduentByCidDao.getStudents().size()+"");
              studentAlert.setView(studentListView);
              studentAlert.show();
        }else if(dao.equals(bandParentDao)){
            this.finish();
        }
    }

    @Override
    public void onDataFailed(BaseDao dao) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent.equals(schoolList)) {
            SchoolListAdpater adpater = (SchoolListAdpater) parent.getAdapter();
            ArrayList<SchoolAndAddress> datas = adpater.getDatas();
            edit_school.setText(datas.get(position).getSchoolName());
            sid = datas.get(position).getSid();
            schoolAlert.dismiss();
        } else if (parent.equals(classList)) {
            ClassListAdpater classAdapter = (ClassListAdpater) parent.getAdapter();
            ArrayList<Class> datas = classAdapter.getDatas();
            edit_class.setText(datas.get(position).getGrade() + "年" + datas.get(position).getNo() + "班");
            cid = datas.get(position).getCid();
            Log.d("CreateStudent", cid + "");
            classDialog.dismiss();

        }else if(parent.equals(studentList)) {
            StudentListAdapter studentListAdapter = (StudentListAdapter) parent.getAdapter();
            Student student = (Student) studentListAdapter.getItem(position);
            edt_name.setText(student.getName());
            edit_studentid.setText(student.getStudentId() + "");
            stid = student.getStid();
            studentAlert.dismiss();
        }
    }
}
