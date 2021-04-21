package com.changpeng.coustomview.chapt_12;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.logging.Logger;

/**
 * @auther: created by pengchang
 * @date: 4/21/21
 * @mail: 1171345871@qq.com
 * 描述:
 */
public class FlowLayout extends ViewGroup {


    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int measureWith = MeasureSpec.getSize(widthMeasureSpec);// FlowLayout 的测量宽度
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);// FlowLayout 的测量高度
        int measureWithMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        int lineHeight = 0; // 记录每一行的行高
        int lineWith = 0; // 记录每一行的宽度

        int height = 0; // 记录整个控件的高度
        int with = 0; // 记录整个控件的宽度

        int chileCount = getChildCount();//获取所有子控件的数量

        for (int i = 0; i < chileCount; i++) {
            View child = getChildAt(i);

            measureChild(child,widthMeasureSpec,heightMeasureSpec);//测量每个子控件的宽高

            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

            // 子控件的宽高应该加上本身的左右margin/上下margin

            int childWith = child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;
            int childHeight = child.getMeasuredHeight()+lp.topMargin+lp.bottomMargin;

            if (lineWith+childWith>measureWith){ // 当flowLayout一行的宽度不足以放置一个子控件的宽度时 需要换行

                with = Math.max(childWith,lineWith);
                height+= lineHeight;
                //换行后每一行的宽高需要初始化
                lineHeight = childHeight;
                lineWith = childWith;
            }else {

              //如果不换行 行高lineHeight应该是lineHeight和childHeight两者中的最大值

              lineHeight =Math.max(lineHeight,childHeight);
              lineWith += childWith;


            }

            if (i==chileCount-1){ // 最后一行单独处理
                height+=lineHeight;
                with = Math.max(with,lineWith);

            }

        }

        Log.d("cahngpeng ","height = "+height);

        setMeasuredDimension(measureWithMode == MeasureSpec.EXACTLY?measureWith:with
                ,measureHeightMode== MeasureSpec.EXACTLY?measureHeight:height);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int count = getChildCount();// 获取子控件的数量
        int lineHeight = 0;// 当前行的行高
        int lineWith =0;// 累加当前行的行宽
        int top =0,left=0;//当前控件的top坐标和left坐标

        // 计算每个控件的位置

        for (int i = 0; i <count ; i++) {



            View child = getChildAt(i);

            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWith = child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;
            int childHeight = child.getMeasuredHeight()+lp.topMargin+lp.bottomMargin;

            if (childWith+lineWith>getMeasuredWidth()){ // 如果需要换行

                top+=lineHeight;
                left=0;
                lineHeight = childHeight;
                lineWith = childWith;
            }else {
                lineHeight =Math.max(lineHeight,childHeight);
                lineWith+=childWith;
            }

            // 计算child的left top right bottom

            int lc = left+lp.leftMargin;
            int tc = top+lp.topMargin;
            int rc = lc+child.getMeasuredWidth();
            int bc = tc+child.getMeasuredHeight();

            child.layout(lc,tc,rc,bc);

            // 将left置为下一个子控件的起始点
            left+= childWith;



        }
    }


    // 获取MarginLayoutParams参数时候，必须重写以下几个方法
    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);
    }


    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
    }
}
