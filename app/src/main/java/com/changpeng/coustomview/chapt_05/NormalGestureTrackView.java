package com.changpeng.coustomview.chapt_05;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 版权:pengchang
 * 版本:1.0
 *
 * @auther: created by pengchang
 * @date: 4/6/21
 * @mail: 1171345871@qq.com
 * 描述: 手势轨迹 手写
 */
public class NormalGestureTrackView extends View {

    private Paint mPaint;
    private Path mPath = new Path();
    public NormalGestureTrackView(Context context) {
        super(context);
        initParams();
    }

    public NormalGestureTrackView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initParams();
    }

    public NormalGestureTrackView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initParams();
    }

    private void initParams(){
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
    }

    private float mPreX,mPreY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // 1。使用贝济埃曲线改造，能够避免lineTo()不平滑的问题
        // 2。寻找起始点和终点

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(event.getX(),event.getY());
                // 以下代码 贝济埃曲线起始点

                mPreX = event.getX();
                mPreY = event.getY();
                return true;

            case MotionEvent.ACTION_MOVE:

//                mPath.lineTo(event.getX(),event.getY());// lineTo()函数画出来的轨迹不够平滑过渡

                // 贝济埃曲线 平滑过渡
                float endX = (mPreX+event.getX())/2;
                float endY = (mPreY+event.getY())/2;
                mPath.quadTo(mPreX,mPreY,endX,endY);

                mPreX = event.getX();
                mPreY = event.getY();
//                invalidate(); // 必须在主线程执行
                postInvalidate(); // handler发消息在主线程执行  可以在任何线程中调用
                break;

            default:
                break;

        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);
        canvas.drawPath(mPath,mPaint);
    }
}
