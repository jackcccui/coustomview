package com.changpeng.coustomview.chapt1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 版权:pengchang
 * 版本:1.0
 *
 * @auther: created by pengchang
 * @date: 3/11/21
 * @mail: 1171345871@qq.com
 * 描述: 自定义椭圆
 */
public class OvalView extends View {
    public OvalView(Context context) {
        super(context);
    }

    public OvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 1.原理 根据矩形生成椭圆
        RectF rect = new RectF(100,10,300,100);
        Paint paint =new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(5);
        // 画一个矩形
        canvas.drawRect(rect,paint);

        paint.setColor(Color.GREEN);
        canvas.drawOval(rect,paint);


    }

}
