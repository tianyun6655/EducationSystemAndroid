package com.tianyunchen.educationsystem;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v4.app.*;

import fragment.ParentSignUpFragment;
import fragment.TeacherSignUpFragment;

/**
 * Created by tianyun chen on 2016/10/19.
 */
public class SignUpActivity extends BaseActivity implements Animator.AnimatorListener {
    private RelativeLayout choiceLayout;
    private View moveView;
    private TextView teacherText;
    private TextView parentText;
    private  ObjectAnimator rightMove;
    private  ObjectAnimator leftMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initViews();
        bindListener();
        initFragment();
    }

    @Override
    public void initViews() {
        choiceLayout = (RelativeLayout)findViewById(R.id.choice_layout);
        teacherText = (TextView)findViewById(R.id.tv_teacher);
        parentText =(TextView)findViewById(R.id.tv_parent);
        ViewTreeObserver viewTreeObserver = choiceLayout.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                moveView = findViewById(R.id.move_white);
                int halfwidth  = choiceLayout.getWidth()/2;
                float x = choiceLayout.getX();
                ViewGroup.LayoutParams layoutParams = moveView.getLayoutParams();
                layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
                layoutParams.width = halfwidth;
                moveView.setLayoutParams(layoutParams);
                return true;
            }
        };
         viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
    }

    private void bindListener(){
        teacherText.setOnClickListener(this);
        parentText.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
       int id = view.getId();
        float endX = choiceLayout.getWidth()/2;

        if(id==parentText.getId()){
            Log.d("SignUp1", choiceLayout.getX()+""+"end: "+ endX+"");
            rightMove =ObjectAnimator.ofFloat(moveView,"translationX",moveView.getX(),endX);
            rightMove.addListener(this);
            rightMove.start();

        }else if(id ==teacherText.getId()){
            Log.d("SignUp12",moveView.getX()+"");
            leftMove =ObjectAnimator.ofFloat(moveView,"translationX",moveView.getX(),0);
            leftMove.addListener(this);
            leftMove.start();
        }
    }

    private void initFragment(){
        TeacherSignUpFragment teacherSignUpFragment = new TeacherSignUpFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content,teacherSignUpFragment).commit();
    }

    @Override
    public void onAnimationStart(Animator animator) {
        if(animator == rightMove){
            teacherText.setTextColor(getResources().getColor(R.color.white));

        }else  if(animator ==leftMove){
            teacherText.setTextColor(getResources().getColor(R.color.colorPrimary));

        }
    }

    @Override
    public void onAnimationEnd(Animator animator) {
       if(animator==rightMove){
           parentText.setTextColor(getResources().getColor(R.color.colorPrimary));
           getSupportFragmentManager().beginTransaction().replace(R.id.content,new ParentSignUpFragment()).commit();

       }else  if(animator ==leftMove){
           parentText.setTextColor(getResources().getColor(R.color.white));
           getSupportFragmentManager().beginTransaction().replace(R.id.content,new TeacherSignUpFragment()).commit();

       }
    }

    @Override
    public void onAnimationCancel(Animator animator) {

    }

    @Override
    public void onAnimationRepeat(Animator animator) {

    }
}
