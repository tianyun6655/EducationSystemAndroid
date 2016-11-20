package fragment;

/**
 * Created by tianyun chen on 2016/11/1.
 */
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tianyunchen.educationsystem.R;
import adapter.StudentInformationAdapter;
import dao.BaseDao;
import dao.GetStudentByPidDao;
import listen.DaoListener;
import untils.SharedPreferenceUtils;

public class StudentInfromationFragment extends Fragment implements StudentInformationAdapter.StudentCallBack, DaoListener {
    private RecyclerView recyclerView;
    private GetStudentByPidDao getStudentByPidDao;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_information,null,false);
        initView(view);
        getOnlineData();

        return view;
    }


    private void getOnlineData(){
        getStudentByPidDao = new GetStudentByPidDao();
        getStudentByPidDao.setDaoListener(this);
        getStudentByPidDao.setPid(SharedPreferenceUtils.getPid(getActivity()));


    }
    private  void initView(View v){
        recyclerView = (RecyclerView)v.findViewById(R.id.student_recycle);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

    }

    @Override
    public void callback(int stid) {
        Log.d("StInformation",stid+"");
        StudentDetailFragment studentDetailFragment = new StudentDetailFragment();
         studentDetailFragment.setStid(stid);
         getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content,studentDetailFragment).commit();

    }

    @Override
    public void onDataLoaded(BaseDao dao) {
        if(dao.equals(getStudentByPidDao)){
            if(getStudentByPidDao.getStudents()!=null){
            StudentInformationAdapter studentInformationAdapter = new StudentInformationAdapter(getActivity(),getStudentByPidDao.getStudents());
            studentInformationAdapter.setCallBack(this);
            recyclerView.setAdapter(studentInformationAdapter);
            recyclerView.addItemDecoration(new MyItemDec());
            }else{
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content,new ErrorFragment()).commit();
            }
        }

    }

    @Override
    public void onDataFailed(BaseDao dao) {

    }

    private class MyItemDec extends RecyclerView.ItemDecoration{
       @Override
       public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
           outRect.bottom=10;
           outRect.right=10;
       }
   }

}
