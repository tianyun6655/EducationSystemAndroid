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
import android.widget.ExpandableListView;

import com.tianyunchen.educationsystem.R;

import adapter.ClassExpandListAdapter;

public class ClassListFragment extends Fragment{

    private ExpandableListView expandableListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_class_list,container,false);
        initView(view);
        return view;
    }


    private void initView(View view){
        expandableListView = (ExpandableListView)view.findViewById(R.id.class_list);
        ClassExpandListAdapter classExpandListAdapter  = new ClassExpandListAdapter(getActivity());
        expandableListView.setAdapter(classExpandListAdapter);
    }
}
