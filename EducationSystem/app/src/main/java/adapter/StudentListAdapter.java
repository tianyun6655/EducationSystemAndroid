package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tianyunchen.educationsystem.R;

import java.util.ArrayList;

import bean.Student;

/**
 * Created by tianyunchen on 11/19/16.
 */

public class StudentListAdapter extends BaseAdapter {
    private ArrayList<Student> datas;
    private Context context;

    public StudentListAdapter(Context context,ArrayList<Student> datas) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_student_listview, null, false);
        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tv_studentID = (TextView)convertView.findViewById(R.id.tv_id);
        tv_name.setText(datas.get(position).getName());
        tv_studentID.setText(datas.get(position).getStudentId()+"");
        return  convertView;
    }



}
