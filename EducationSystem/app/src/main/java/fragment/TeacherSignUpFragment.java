package fragment;

/**
 * Created by tianyun chen on 2016/10/20.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tianyunchen.educationsystem.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import adapter.ClassListAdpater;
import adapter.ClassRecycleViewAdapter;
import adapter.SchoolListAdpater;
import bean.Class;
import bean.SchoolAndAddress;
import dao.BaseDao;
import dao.GetClassDao;
import dao.GetSchoolListDao;
import dao.SignUpAsTeacherDao;
import listen.DaoListener;

public class TeacherSignUpFragment extends Fragment implements View.OnClickListener, DaoListener,AdapterView.OnItemClickListener {
    private final  String TAG ="TeacherSignUpFragment";
    private TextView addClass;
    private LinearLayout addLayout;
    private RecyclerView recyclerView;
    private ArrayList<Class> classData;
    private ClassRecycleViewAdapter classRecycleView;
    private TextView edit_school;
    private EditText edit_name;
    private EditText edit_password;
    private EditText edit_mobile;

    private Button btn_sign_up;

    private ListView schoolList;
    private ListView classList;

    private  View dialogView;

    private SignUpAsTeacherDao signUpAsTeacherDao;
    private  GetSchoolListDao getSchoolListDao;
    private  GetClassDao getClassDao;

    private AlertDialog alertDialog;
    private AlertDialog classDialog;
    private AlertDialog errorDialog;

    private int sid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_teacher_sign_up,container,false);
         initView(view);
         return view;

    }

    private void initView(View view){
        edit_name = (EditText)view.findViewById(R.id.edt_name);
        edit_mobile= (EditText)view.findViewById(R.id.edt_mobile);
        edit_password = (EditText)view.findViewById(R.id.edt_password);
        addClass= (TextView)view.findViewById(R.id.tv_add_class);
        addClass.setOnClickListener(this);
        btn_sign_up = (Button)view.findViewById(R.id.btn_sign_up);
        btn_sign_up.setOnClickListener(this);
        addLayout = (LinearLayout)view.findViewById(R.id.add_layout);
        recyclerView = (RecyclerView)view.findViewById(R.id.class_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        classData = new ArrayList<Class>();
        classRecycleView = new ClassRecycleViewAdapter(getActivity(),classData);
        recyclerView.setAdapter(classRecycleView);
        edit_school = (TextView)view.findViewById(R.id.edt_school);
        edit_school.setOnClickListener(this);
        alertDialog  =new AlertDialog.Builder(getActivity()).create();
        dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.alert_school_list,null);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == edit_school.getId()){
            getSchoolListDao = new GetSchoolListDao();
            getSchoolListDao.setParamer();
            getSchoolListDao.setDaoListener(this);
        }else if (id==addClass.getId()){
            getClassDao = new GetClassDao();
            getClassDao.setData(sid);
            getClassDao.setDaoListener(this);
        }else if(id==btn_sign_up.getId()){
            classRecycleView.getDatas();
            JSONArray jsonArray = new JSONArray();
            for(int i =0;i<classRecycleView.getDatas().size();i++){
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("cid",classRecycleView.getDatas().get(i).getCid()+"");
                    jsonArray.put(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Log.d(TAG,"json; "+jsonArray.toString());
            signUpAsTeacherDao  = new SignUpAsTeacherDao();
            signUpAsTeacherDao.setData(edit_name.getText().toString(),edit_password.getText().toString(),edit_mobile.getText().toString(),jsonArray.toString());
        }
    }

    @Override
    public void onDataLoaded(BaseDao dao) {
        if(dao.equals(getSchoolListDao)){
            schoolList = (ListView)dialogView.findViewById(R.id.alert_list);
            Log.d("TeacherSignUpFragment",getSchoolListDao.getSchoolAndAddresseslist().size()+"");
            schoolList.setAdapter(new SchoolListAdpater(getActivity(),getSchoolListDao.getSchoolAndAddresseslist()));
            schoolList.setOnItemClickListener(TeacherSignUpFragment.this);
            alertDialog.setView(dialogView);
            alertDialog.show();
        }else if (dao.equals(getClassDao)){
            classDialog = new AlertDialog.Builder(getActivity()).create();
            View classDiagoView = LayoutInflater.from(getActivity()).inflate(R.layout.alert_school_list,null);
            classList = (ListView)classDiagoView.findViewById(R.id.alert_list);
            classList.setAdapter(new ClassListAdpater(getActivity(),getClassDao.getDatas()));
            classList.setOnItemClickListener(TeacherSignUpFragment.this);
            classDialog.setView(classDiagoView);
            classDialog.show();
       }
    }

    @Override
    public void onDataFailed(BaseDao dao) {
        View errorView  = LayoutInflater.from(getActivity()).inflate(R.layout.alert_error_view,null,false);
           alertDialog = new AlertDialog.Builder(getActivity()).create();
           alertDialog.setView(errorView);
           alertDialog.show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.equals(schoolList)) {
            SchoolListAdpater adpater = (SchoolListAdpater) adapterView.getAdapter();
            ArrayList<SchoolAndAddress> datas = adpater.getDatas();
            edit_school.setText(datas.get(i).getSchoolName());
            sid = datas.get(i).getSid();
            alertDialog.dismiss();
        }else if(adapterView.equals(classList)){
            ClassListAdpater classAdapter = (ClassListAdpater) adapterView.getAdapter();
            ArrayList<Class> datas = classAdapter.getDatas();
            Log.d("TeacherFragment",datas.get(i).getCid()+"");
            classRecycleView.inserItem(datas.get(i));
            classDialog.dismiss();

        }
    }
    private void showClassDigol(){
        classList = (ListView) dialogView.findViewById(R.id.alert_list);
    }
}
