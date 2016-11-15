package fragment;

/**
 * Created by tianyun chen on 2016/10/31.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tianyunchen.educationsystem.R;

import java.util.ArrayList;

import bean.ChartDataItem;
import view.ChartView;

public class GradeFrameLayout extends Fragment{
    private ChartView chartView;
    private ArrayList<ChartDataItem> dataItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_grade,null,false);
        iniitDatas();
        initView(view);
        return  view;
    }


    private void initView(View view){
        chartView = (ChartView)view.findViewById(R.id.grade_chart);
        chartView.setData(dataItems);

    }
    private void iniitDatas(){
        dataItems =  new ArrayList<ChartDataItem>();
        dataItems.add(new ChartDataItem("09/8",53));
        dataItems.add(new ChartDataItem("09/17",65));
        dataItems.add(new ChartDataItem("09/24",75));
        dataItems.add(new ChartDataItem("09/30",84));
        dataItems.add(new ChartDataItem("10/4",47));
        dataItems.add(new ChartDataItem("10/9",95));
    }
}
