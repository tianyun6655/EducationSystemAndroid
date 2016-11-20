package adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tianyunchen.educationsystem.R;

import java.util.ArrayList;

import bean.Parent;
import bean.Teacher;

/**
 * Created by tianyun chen on 2016/10/20.
 */
public class ClassExpandListAdapter implements ExpandableListAdapter {
    private String[] firstList = new String[]{"老师","家长"};
    private String[][] secondlist = new String[][]{ {"张小帅（数学）","陈中帅（语文）"},
                                        {"吴帅帅","李赛高"},
                                       };
    private ArrayList<Parent> parents;
    private ArrayList<Teacher> teachers;
    private Context context;

   public    ClassExpandListAdapter(Context context,ArrayList<Teacher> teachers,ArrayList<Parent> parents){
       this.teachers  = teachers;
       this.parents = parents;
        this.context =context;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getGroupCount() {
        return firstList.length;
    }

    @Override
    public int getChildrenCount(int i) {
        if(i==0){
            return teachers.size();
        }else {
            return parents.size();
        }
        //return secondlist[i].length;
    }

    @Override
    public Object getGroup(int i) {
        return firstList[i];
    }

    @Override
    public Object getChild(int i, int i1)
    {
        if(i==0){
            return teachers.get(i1);
        }else if(i==1){
            return parents.get(i1);
        }
        return 01;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.item_group,viewGroup,false);
        TextView textView = (TextView)view1.findViewById(R.id.tv_group);
        textView.setText(firstList[i]);
        return view1;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
    /*    TextView textView = new TextView(context);
        textView.setTextSize(15);

        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        textView.setLayoutParams(layoutParams);
        textView.setTextColor(0xbdbdbd);
        textView.setText(secondlist[i][i1]);
*/
        View view1 = LayoutInflater.from(context).inflate(R.layout.item_child,viewGroup,false);
        TextView textView = (TextView)view1.findViewById(R.id.tv_child);
        TextView lastName = (TextView)view1.findViewById(R.id.tv_last_name);
        if(i==0){
            lastName.setText(teachers.get(i1).getName().substring(0,1));
            textView.setText(teachers.get(i1).getName());
        }else if(i==1){
            lastName.setText(parents.get(i1).getName().substring(0,1));
            textView.setText(parents.get(i1).getName());
        }
       /* lastName.setText(secondlist[i][i1].substring(0,1));
        textView.setText(secondlist[i][i1]);*/
        return view1;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int i) {

    }

    @Override
    public void onGroupCollapsed(int i) {

    }

    @Override
    public long getCombinedChildId(long l, long l1) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long l) {
        return 0;
    }

}
