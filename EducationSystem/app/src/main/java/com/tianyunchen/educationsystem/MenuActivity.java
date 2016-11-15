package com.tianyunchen.educationsystem;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.ImageFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import  android.support.v4.app.*;
import android.widget.TextView;

import org.w3c.dom.Text;

import fragment.ClassListFragment;

/**
 * Created by tianyun chen on 2016/10/20.
 */
public class MenuActivity extends BaseActivity implements Animator.AnimatorListener {
    private View moveView;
    private RelativeLayout choiceLayout;
    private TextView tvListClass;
    private TextView tvAunncoument;
    private TextView tvMessage;
    private ObjectAnimator moveToAuncoument;
    private ObjectAnimator moveToMessage;
    private ObjectAnimator moveToClass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_layout);
        initViews();
        bandLisenter();
        initFragment();
    }

    @Override
    public void initViews() {
        moveView = findViewById(R.id.move_white);
        choiceLayout=(RelativeLayout)findViewById(R.id.choice_layout);
        tvListClass = (TextView)findViewById(R.id.tv_list_class);
        tvAunncoument =(TextView)findViewById(R.id.tv_announcment);
        tvMessage = (TextView)findViewById(R.id.tv_message);

        ViewTreeObserver viewTreeObserver = choiceLayout.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener  drawListener = new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                ViewGroup.LayoutParams layoutParams = moveView .getLayoutParams();
                layoutParams.width = choiceLayout.getWidth()/3;
                moveView.setLayoutParams(layoutParams);
                return true;
            }
        };
        viewTreeObserver.addOnPreDrawListener(drawListener);

    }
 private void bandLisenter()
 {
     tvListClass.setOnClickListener(this);
     tvAunncoument.setOnClickListener(this);
     tvMessage.setOnClickListener(this);
 }
    private void initFragment(){
        ClassListFragment classListFragment = new ClassListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content,classListFragment).commit();
    }
    @Override
    public void onClick(View view) {
            int id = view.getId();
        if (id ==tvListClass.getId()){
            moveToClass = ObjectAnimator.ofFloat(moveView,"translationX",moveView.getX(),0);
            moveToClass.addListener(this);
            moveToClass.start();
        } else  if(id ==tvAunncoument.getId()){
            float endX = choiceLayout.getWidth()/3;

            moveToAuncoument = ObjectAnimator.ofFloat(moveView,"translationX",moveView.getX(),endX);
            moveToAuncoument.addListener(this);
            moveToAuncoument.start();

        }else  if(id ==tvMessage.getId()){
            float endX = choiceLayout.getWidth()*2/3;
            moveToMessage = ObjectAnimator.ofFloat(moveView,"translationX",moveView.getX(),endX);
            moveToMessage.addListener(this);
            moveToMessage.start();
        }
    }

    @Override
    public void onAnimationStart(Animator animator) {
        if(animator == moveToAuncoument){
            tvListClass.setTextColor(getResources().getColor(R.color.white));
            tvMessage.setTextColor(getResources().getColor(R.color.white));
        }else  if (animator==moveToMessage){
            tvAunncoument.setTextColor(getResources().getColor(R.color.white));
            tvListClass.setTextColor(getResources().getColor(R.color.white));

        }else if(animator ==moveToClass){
            tvAunncoument.setTextColor(getResources().getColor(R.color.white));
            tvMessage.setTextColor(getResources().getColor(R.color.white));
        }
    }

    @Override
    public void onAnimationEnd(Animator animator) {
           if(animator==moveToAuncoument){
               tvAunncoument.setTextColor(getResources().getColor(R.color.colorPrimary));

           }else  if(animator==moveToMessage){
               tvMessage.setTextColor(getResources().getColor(R.color.colorPrimary));

           }else if(animator ==moveToClass){
               tvListClass.setTextColor(getResources().getColor(R.color.colorPrimary));

           }
    }

    @Override
    public void onAnimationCancel(Animator animator) {

    }

    @Override
    public void onAnimationRepeat(Animator animator) {

    }
}
