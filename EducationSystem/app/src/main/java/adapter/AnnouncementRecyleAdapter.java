package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tianyunchen.educationsystem.R;

import java.util.ArrayList;

import bean.Announcement;

/**
 * Created by Tianyun on 2016/11/15.
 */

public class AnnouncementRecyleAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Announcement> announcements;
    public AnnouncementRecyleAdapter(Context context,ArrayList<Announcement> announcements){
         this.context =context;
        this.announcements =announcements;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyle_announcement,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyViewHolder){
            MyViewHolder tempHolder = (MyViewHolder) holder;
            tempHolder.tv_title.setText(announcements.get(position).getTitle());
            tempHolder.tv_content.setText(announcements.get(position).getContent());
            tempHolder.tv_date.setText(announcements.get(position).getDate());
        }

    }

    @Override
    public int getItemCount() {
        return announcements.size();
    }

    private class  MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_title;
        private TextView tv_content;
        private TextView tv_date;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView)itemView.findViewById(R.id.tv_title);
            tv_content =(TextView)itemView.findViewById(R.id.tv_content);
            tv_date = (TextView)itemView.findViewById(R.id.tv_date);
        }
    }
}
