package adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tianyunchen.educationsystem.R;

import java.util.ArrayList;

import bean.ChartDataItem;

/**
 * Created by tianyun chen on 2016/10/24.
 */
public class DataRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<ChartDataItem> items;
    private  View view;
    private int gap;
    private int size;
    public DataRecycleAdapter(Context context, ArrayList<ChartDataItem> items, int gap, int size) {
        this.context =context;
        this.items =items;
        this.gap = gap;
        this.size =size;
        Log.d("gapansize",gap+" "+size+"");

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_data_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         if(holder instanceof MyViewHolder){
             MyViewHolder myViewHolder = (MyViewHolder)holder;

             view.measure(0,0);
             Log.d("height: ",view.getMeasuredHeight()+"");

             myViewHolder.tv_colunm.measure(0,0);
             float pceHeight = items.get(position).getYaxia()/10;
             int  itemHeight = (int)(gap*pceHeight);
             Log.d("realHeight",itemHeight+"");


             ViewGroup.LayoutParams layoutParams = myViewHolder.tv_colunm.getLayoutParams();
             layoutParams.height = itemHeight+size;
             myViewHolder.tv_colunm.setLayoutParams(layoutParams);
             if(items.get(position).getYaxia()<60){
                 myViewHolder.tv_colunm.setBackgroundResource(R.drawable.fale_shape);
                 myViewHolder.tv_score.setTextColor(context.getResources().getColor(R.color.fale));
             }
             Log.d("tv_height: ",myViewHolder.tv_colunm.getMeasuredHeight()+"");
             ObjectAnimator animator = ObjectAnimator.ofFloat(myViewHolder.tv_colunm, "scaleY", 0,1,1);
             animator.setDuration(1000);
             animator.start();

             myViewHolder.tv_score.setText(items.get(position).getYaxia()+"");


         }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    private  class MyViewHolder extends RecyclerView.ViewHolder{
         TextView tv_colunm;
        TextView tv_score;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_colunm = (TextView)itemView.findViewById(R.id.column);
            tv_score=(TextView)itemView.findViewById(R.id.tv_score);

        }
    }
}
