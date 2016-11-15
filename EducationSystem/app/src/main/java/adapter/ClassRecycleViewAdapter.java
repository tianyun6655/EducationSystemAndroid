package adapter;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tianyunchen.educationsystem.R;

import java.util.ArrayList;

import bean.Class;

/**
 * Created by tianyun chen on 2016/10/20.
 */
public class ClassRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Class> data;
    public ClassRecycleViewAdapter(Context context, ArrayList<Class> data){
        this.context = context;
        this.data = data;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycle_class,parent,false));

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder)holder;
        myViewHolder.tv_class.setText(data.get(position).getGrade()+"年"+data.get(position).getNo()+"班");

    }



    @Override
    public int getItemCount() {
        return data.size();
    }

   public  void inserItem(Class newclass){
       data.add(newclass);
       this.notifyItemInserted(data.size()-1);

   }


    private class MyViewHolder extends RecyclerView.ViewHolder{
       TextView tv_class;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_class = (TextView)itemView.findViewById(R.id.tv_class);
        }
    }

    public  ArrayList<Class> getDatas(){
        return  data;
    }
}
