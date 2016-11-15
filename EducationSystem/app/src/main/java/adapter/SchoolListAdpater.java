package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tianyunchen.educationsystem.R;

import java.util.ArrayList;

import bean.SchoolAndAddress;

/**
 * Created by tianyun chen on 2016/11/2.
 */
public class SchoolListAdpater extends BaseAdapter {
    private Context context;
    private ArrayList<SchoolAndAddress> datas;

    public SchoolListAdpater(Context context, ArrayList<SchoolAndAddress> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_alert_school_list, null, false);
        TextView schoolName = (TextView) view.findViewById(R.id.tv_school_name);
        TextView locaion = (TextView) view.findViewById(R.id.tv_school_address);
        schoolName.setText(datas.get(i).getSchoolName());
        locaion.setText(datas.get(i).getLocation());
        return view;
    }

    public void updataDatas(ArrayList<SchoolAndAddress> schoolAndAddresses) {
        this.datas = schoolAndAddresses;
    }
    public ArrayList<SchoolAndAddress> getDatas(){
        return  datas;
    }
}
