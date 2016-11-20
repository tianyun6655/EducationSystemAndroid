package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tianyunchen.educationsystem.MenuActivity;
import com.tianyunchen.educationsystem.R;

import java.util.ArrayList;

import bean.Student;

/**
 * Created by tianyun chen on 2016/11/2.
 */
public class InfromationAdapter extends BaseAdapter {
    private Context context;
    private Student student;
    public InfromationAdapter(Context context,Student student) {
        this.context =context;
        this.student = student;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int i) {
        return student;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_student_list,null,false);
        TextView name_text = (TextView)view.findViewById(R.id.name_text);
        TextView tv_content = (TextView)view.findViewById(R.id.tv_content);
        if (i==0){
            name_text.setText("姓名:");
             tv_content.setText(student.getName());
        }else if(i==1){
            name_text.setText("学生学号:");
            tv_content.setText(student.getStudentId()+"");

        }else if(i==2){
            name_text.setText("学生生日:");
            tv_content.setText(student.getBirthday());

        }else if(i==3){
            name_text.setText("跟踪学生成绩");
            tv_content.setText("");

        }else if(i==4){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MenuActivity.class);
                    context.startActivity(intent);
                }
            });
            name_text.setText("进入班级");
            tv_content.setText("");
        }
        return view;
    }
}
