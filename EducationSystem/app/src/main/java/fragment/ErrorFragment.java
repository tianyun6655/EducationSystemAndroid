package fragment;

/**
 * Created by tianyun chen on 2016/10/31.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tianyunchen.educationsystem.CreateStudentAcitivity;
import com.tianyunchen.educationsystem.R;

public class ErrorFragment extends Fragment implements View.OnClickListener {
   private Button btn_createStudent;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_no_stundet_error,null,false);


        initViews(view);
        bandLinstener();
        return view;

    }

    private void  initViews(View view){
      btn_createStudent = (Button)view.findViewById(R.id.btn_create_student);

    }


    private void bandLinstener(){
        btn_createStudent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), CreateStudentAcitivity.class);
        getActivity().startActivity(intent);

    }
}
