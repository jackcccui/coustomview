package com.changpeng.coustomview.chapt1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class BasisView extends View {


    public BasisView(Context context) {
        super(context);
    }

    public BasisView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BasisView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();// 先得到一个画笔
        paint.setColor(Color.RED); //设置画笔颜色
        paint.setStyle(Paint.Style.FILL_AND_STROKE);//设置填充样式
        paint.setStrokeWidth(10);//设置画笔宽度
        canvas.drawCircle(190,200,150,paint);//画一个圆形 设置圆心的x（190）、y（200）坐标和半径（150）

//        canvas.drawColor(Color.GREEN); 设置画布颜色
        // 画第二个圆 两个圆 圆心相同 叠加效果
//        paint.setColor(0x7effff00); // 设置画笔颜色
        canvas.drawCircle(190,200,100,paint);//设置圆的坐标、半径和画笔
        canvas.drawLine(300,300,700,800,paint);
    }
}
