package view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by tianyun chen on 2016/11/15.
 */
public class RecycleVertialItemDiv extends RecyclerView.ItemDecoration {

    private Drawable mdivider;

    private static final int[]  ATTRS = new int[]{
            android.R.attr.listDivider
    };

    public RecycleVertialItemDiv(Context context) {
       final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mdivider = a.getDrawable(0);

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        final  int left = parent.getPaddingLeft();
        final  int right = parent.getWidth()-parent.getPaddingRight();
        final  int count = parent.getChildCount();
        for (int i=0;i<count;i++){
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mdivider.getIntrinsicHeight();
            mdivider.setBounds(left, top, right, bottom);
            mdivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom=10;
        outRect.right=10;
    }
}
