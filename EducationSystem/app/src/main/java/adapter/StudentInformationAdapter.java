package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tianyunchen.educationsystem.R;

/**
 * Created by tianyun chen on 2016/11/1.
 */
public class StudentInformationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    private Context context;
    private StudentCallBack studentCallBack;
    public StudentInformationAdapter(Context context) {
    this.context = context;
    }

    public void setCallBack(StudentCallBack studentCallBack){
        this.studentCallBack = studentCallBack;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_student_recycle,null,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onClick(View view) {
        if(studentCallBack!=null){
        studentCallBack.callback();}
    }

    private  class  MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(StudentInformationAdapter.this);
        }
    }

    public interface StudentCallBack{
        public void callback();
    }
}
