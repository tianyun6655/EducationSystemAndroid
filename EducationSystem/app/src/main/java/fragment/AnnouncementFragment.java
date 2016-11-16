package fragment;

/**
 * Created by tianyun chen on 2016/10/22.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tianyunchen.educationsystem.R;

import adapter.AnnouncementRecyleAdapter;
import dao.BaseDao;
import dao.GetAnnouncementByClassDao;
import listen.DaoListener;
import view.RecycleVertialItemDiv;

public class AnnouncementFragment extends Fragment implements DaoListener{
    private RecyclerView recyclerViewAnnouncement;
    private GetAnnouncementByClassDao getAnnouncementByClassDao;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View view = inflater.inflate(R.layout.fragment_announcement,container,false);
        getAnnouncementByClassDao = new GetAnnouncementByClassDao();
        getAnnouncementByClassDao.setCid(1);
          initViews(view);
          return view;
    }

    private void initViews(View view){
        recyclerViewAnnouncement = (RecyclerView)view.findViewById(R.id.recycle_announcment);
        recyclerViewAnnouncement.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewAnnouncement.addItemDecoration(new RecycleVertialItemDiv(getActivity()));
        recyclerViewAnnouncement.setAdapter(new AnnouncementRecyleAdapter(getActivity()));
    }


    @Override
    public void onDataLoaded(BaseDao dao) {

    }

    @Override
    public void onDataFailed(BaseDao dao) {

    }
}
