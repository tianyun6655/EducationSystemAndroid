package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tianyunchen.educationsystem.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import bean.StudentListItem;

/**
 * Created by tianyun chen on 2016/11/1.
 */
public class StudentInformationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private StudentCallBack studentCallBack;
    private ArrayList<StudentListItem> datas;
    public StudentInformationAdapter(Context context,ArrayList<StudentListItem> datas) {
    this.context = context;
        this.datas =datas;
    }

    public void setCallBack(StudentCallBack studentCallBack){
        this.studentCallBack = studentCallBack;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

         view = LayoutInflater.from(context).inflate(R.layout.item_student_recycle,null,false);
            return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

         if(holder instanceof MyViewHolder){
             MyViewHolder myViewHolder = (MyViewHolder)holder;
             myViewHolder.tv_schoolName.setText(datas.get(position).getSchoolName());
             myViewHolder.tv_class.setText(datas.get(position).getGrade()+"年"+datas.get(position).getNo()+"班");
             String name = datas.get(position).getName();
             String first_name = name.substring(1,name.length());
             myViewHolder.tv_name.setText(name);
             myViewHolder.tv_first_name.setText(first_name);
             myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     studentCallBack.callback(datas.get(position).getStid());
                 }
             });


         }


    }

    @Override
    public int getItemCount() {
        if(datas==null){return 0;}
        else{
            return datas.size();

        }
    }


    private  class  MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_schoolName;
        TextView tv_class;
        TextView tv_name;
        TextView tv_first_name;
        View itemView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_schoolName = (TextView)itemView.findViewById(R.id.tv_school_name);
            tv_class = (TextView)itemView.findViewById(R.id.tv_class);
            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_first_name = (TextView)itemView.findViewById(R.id.tv_first_name);

        }

    }

    private class EmptyViewHold extends RecyclerView.ViewHolder{

        public EmptyViewHold(View itemView) {
            super(itemView);
        }
    }



    public interface StudentCallBack{
        public void callback(int stid);
    }
}
