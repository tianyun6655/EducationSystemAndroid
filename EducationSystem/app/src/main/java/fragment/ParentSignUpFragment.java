package fragment;

/**
 * Created by tianyun chen on 2016/10/20.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.tianyunchen.educationsystem.R;

import dao.BaseDao;
import dao.SignUpParentDao;
import listen.DaoListener;

public class ParentSignUpFragment extends Fragment implements View.OnClickListener, DaoListener{
    private EditText edit_name;
    private EditText edit_password;
    private EditText edit_mobile;
    private Button btn_signUp;

    private SignUpParentDao signUpParentDao;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
             View view  = inflater.inflate(R.layout.fragment_parent_sign_up,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view){
        edit_mobile = (EditText)view.findViewById(R.id.edt_mobile);
        edit_name = (EditText)view.findViewById(R.id.edt_name);
        edit_password = (EditText)view.findViewById(R.id.edt_password);
        btn_signUp = (Button)view.findViewById(R.id.btn_sign_up);
        btn_signUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
           int id  = view.getId();
        if (id==btn_signUp.getId()){
            signUpParentDao = new SignUpParentDao();
            signUpParentDao.setDaoListener(this);
            signUpParentDao.setDatas(edit_name.getText().toString(),edit_mobile.getText().toString(),edit_password.getText().toString());
        }
    }

    @Override
    public void onDataLoaded(BaseDao dao) {


    }

    @Override
    public void onDataFailed(BaseDao dao) {

    }
}
