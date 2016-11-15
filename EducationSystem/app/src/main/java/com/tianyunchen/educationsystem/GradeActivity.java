package com.tianyunchen.educationsystem;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import bean.ChartDataItem;
import fragment.GradeFrameLayout;
import view.ChartView;


/**
 * Created by tianyun chen on 2016/10/23.
 */
public class GradeActivity extends BaseActivity {
    private RelativeLayout choice_layout;
    private View moveView;
    private ChartView chartView;
    private ArrayList<ChartDataItem> dataItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        initViews();
        initFragment();
    }

    @Override
    public void initViews() {
        moveView = findViewById(R.id.move_white);
        choice_layout = (RelativeLayout)findViewById(R.id.choice_layout);
        ViewTreeObserver viewTreeObserver = choice_layout.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener  drawListener = new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                ViewGroup.LayoutParams layoutParams = moveView .getLayoutParams();
                layoutParams.width = choice_layout.getWidth()/2;
                moveView.setLayoutParams(layoutParams);
                return true;
            }
        };
        viewTreeObserver.addOnPreDrawListener(drawListener);
    }

    private void initFragment(){
        GradeFrameLayout  gradeFrameLayout = new GradeFrameLayout();
        getSupportFragmentManager().beginTransaction().replace(R.id.content,gradeFrameLayout).commit();

    }

    @Override
    public void onClick(View view) {

    }
}
