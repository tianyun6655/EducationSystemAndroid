package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tianyunchen.educationsystem.R;

/**
 * Created by tianyun chen on 2016/11/2.
 */
public class InfromationAdapter extends BaseAdapter {
    private Context context;
    public InfromationAdapter(Context context) {
    this.context =context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_student_list,null,false);
        return view;
    }
}
