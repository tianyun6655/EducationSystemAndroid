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
import dao.BaseDao;
import dao.GetNumberByCidDao;
import listen.DaoListener;

public class ClassListFragment extends Fragment implements DaoListener{

    private ExpandableListView expandableListView;
    private GetNumberByCidDao getNumberByCidDao;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_class_list,container,false);
        initDao();
        initView(view);
        return view;
    }

    private  void initDao(){
        getNumberByCidDao = new GetNumberByCidDao();
        getNumberByCidDao.setCid(3);
        getNumberByCidDao.setDaoListener(this);
    }



    private void initView(View view){
        expandableListView = (ExpandableListView)view.findViewById(R.id.class_list);
//        ClassExpandListAdapter classExpandListAdapter  = new ClassExpandListAdapter(getActivity());
//        expandableListView.setAdapter(classExpandListAdapter);
    }

    @Override
    public void onDataLoaded(BaseDao dao) {
        if (dao.equals(getNumberByCidDao)){
            ClassExpandListAdapter classExpandListAdapter  = new ClassExpandListAdapter(getActivity(),
                    getNumberByCidDao.getTeachers(),getNumberByCidDao.getParents());
            expandableListView.setAdapter(classExpandListAdapter);
        }

    }

    @Override
    public void onDataFailed(BaseDao dao) {

    }
}
