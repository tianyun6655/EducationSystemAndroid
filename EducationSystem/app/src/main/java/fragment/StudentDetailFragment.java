package fragment;

/**
 * Created by tianyun chen on 2016/11/1.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tianyunchen.educationsystem.R;

import adapter.InfromationAdapter;
import adapter.StudentInformationAdapter;

public class StudentDetailFragment extends Fragment {
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View view = inflater.inflate(R.layout.fragment_student_detail,null,false);
        initViews(view);
        return view;
    }

    private void initViews(View view){
        listView = (ListView)view.findViewById(R.id.list_information);
        listView.setAdapter(new InfromationAdapter(getActivity()));
    }
}