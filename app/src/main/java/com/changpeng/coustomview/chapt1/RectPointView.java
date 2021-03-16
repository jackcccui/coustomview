package com.changpeng.coustomview.chapt1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 版权:pengchang
 * 版本:1.0
 *
 * @auther: created by pengchang
 * @date: 3/12/21
 * @mail: 1171345871@qq.com
 * 描述:自定义矩形
 */
public class RectPointView extends View {

    Paint mPaint;
    Rect mRect;
    int mX;
    int mY;
    public RectPointView(Context context) {
        super(context);
        init();
    }



    public RectPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RectPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    /**
     * 初始化一个矩形
     */
    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mRect = new Rect(100,100,400,390);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // 获取手指点击屏幕的坐标
        mX = (int) event.getX();
        mY = (int) event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN){
            // 判断点击的action 如果是ACTION_DOWN 重绘页面
            invalidate(); // 必须在主线程调用
            return true;
        }else if (event.getAction() == MotionEvent.ACTION_UP){
            // 如果手指抬起 离开屏幕 将X、Y的坐标置为-1
            mX = -1;
            mY = -1;

        }
        //重绘
        postInvalidate(); // 发送消息重绘 可以在任意线程中调用 原理就是利用handler发消息告诉主线程重绘页面

        return super.onTouchEvent(event);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //如果手指点击的区域在矩形中 设置成红色 否则设置成绿色
        if (mRect.contains(mX,mY)){
            mPaint.setColor(Color.RED);
        }else {
            mPaint.setColor(Color.GREEN);
        }
        // 绘制矩形
        canvas.drawRect(mRect,mPaint);
    }
}
