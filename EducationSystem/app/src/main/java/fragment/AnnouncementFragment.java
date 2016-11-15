package fragment;

/**
 * Created by tianyun chen on 2016/10/22.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tianyunchen.educationsystem.R;

public class AnnouncementFragment extends Fragment {
    private RecyclerView recyclerViewAnnouncement;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View view = inflater.inflate(R.layout.fragment_announcement,container,false);
          initViews(view);
          return view;
    }

    private void initViews(View view){
        recyclerViewAnnouncement = (RecyclerView)view.findViewById(R.id.recycle_announcment);

    }

}
