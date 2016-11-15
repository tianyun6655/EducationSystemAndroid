package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.tianyunchen.educationsystem.R;

import java.util.ArrayList;

import adapter.DataRecycleAdapter;
import bean.ChartDataItem;

/**
 * Created by tianyun chen on 2016/10/24.
 */
public class ChartView  extends RelativeLayout {
    private Paint paint;
    private View yAxia;
    private Context context;
    private RecyclerView recyclerView;
    private int startindex = 21;
    private int yMax;
    private int yMin;
    private float highestScore;
    private float lowestScore;
    private ArrayList<ChartDataItem> datas;
    public ChartView(Context context) {
        this(context,null);
    }

    public ChartView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context =context;
        setWillNotDraw(false);
        initView();


    }
    private void  initView(){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=   inflater.inflate(R.layout.view_chart,this,true);
        yAxia = view.findViewById(R.id.xAix);
        recyclerView = (RecyclerView)view.findViewById(R.id.dataView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect();
        paint = new Paint();
        paint.setTextSize(23);
        paint.setColor(context.getResources().getColor(R.color.colorPrimary));
        int gap = (yAxia.getBottom()-yAxia.getTop()-21)/10;
        for(int i =100;i>=0;i-=10){
            canvas.drawText(i+"",10 ,yAxia.getTop()+startindex,paint);
            Log.d("top: ","the top: "+yAxia.getTop());
            startindex +=gap;
        }
        if(datas==null){
            datas = new ArrayList<ChartDataItem>();
        }
        for(int i = 0;i<datas.size();i++){

            View view = recyclerView.getChildAt(i);
            Log.d("chiildPosition",view.getX()+""+"length: "+view.getWidth());
            float width = paint.measureText(datas.get(i).getXaxia());
            canvas.drawText(datas.get(i).getXaxia(),view.getX()+width,yAxia.getBottom()+21+15,paint);

        }
    }


    public void setData(ArrayList<ChartDataItem> datas){
        int gap = (yAxia.getBottom()-yAxia.getTop()-21)/10;
        this.datas = datas;
        recyclerView.setAdapter(new DataRecycleAdapter(context,datas,53,gap));
        recyclerView.addItemDecoration(new SpaceItemDecoration(25));
        postInvalidate();

    }

    public class SpaceItemDecoration extends RecyclerView.ItemDecoration{

        private int space;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
        }
    }
}
