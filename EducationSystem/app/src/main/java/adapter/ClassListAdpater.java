package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tianyunchen.educationsystem.BaseActivity;
import com.tianyunchen.educationsystem.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import bean.Class;

/**
 * Created by tianyun chen on 2016/11/3.
 */
public class ClassListAdpater extends BaseAdapter {
private Context context;
    private ArrayList<Class> datas;

    public ClassListAdpater(Context context,ArrayList<Class> datas) {
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
        view = LayoutInflater.from(context).inflate(R.layout.item_class_list,null,false);
        TextView textView  =(TextView) view.findViewById(R.id.tv_class);
        textView.setText(datas.get(i).getGrade()+"年"+datas.get(i).getNo()+"班");
        Log.d("GetViewTest",datas.size()+"");
        return view;
    }

    public ArrayList<Class> getDatas(){
        return  datas;
    }
}
