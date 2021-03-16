package com.changpeng.coustomview.chapt1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 版权:pengchang
 * 版本:1.0
 *
 * @auther: created by pengchang
 * @date: 3/12/21
 * @mail: 1171345871@qq.com
 * 描述:
 */
public class SanjiaoView extends View {
    public SanjiaoView(Context context) {
        super(context);
    }

    public SanjiaoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SanjiaoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        Path path = new Path(); // 创建路径对象
        path.moveTo(20,20);// 设定起始点
        path.lineTo(20,100);// 第一条直线的终点 也是第二条直线的起点
        path.lineTo(200,100);// 画第二条直线
        path.close(); // 闭环形成三角形

        canvas.drawPath(path,paint); // 在画布上画出三角形

    }
}
