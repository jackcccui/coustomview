package com.changpeng.coustomview.chapt1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 版权:pengchang
 * 版本:1.o
 *
 * @auther: created by pengchang
 * @date: 3/11/21
 * @mail: 1171345871@qq.com
 * 描述:
 */
public class ArcView extends View {
    public ArcView(Context context) {
        super(context);
    }

    public ArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        // 弧线两边带两条直线
//
        RectF rectF = new RectF(10,10,100,100);
        canvas.drawArc(rectF,-90,180,true,paint);

        // 不带两边
//        RectF rect2 = new RectF(210, 10, 200, 100);
//        canvas.drawArc(rect2, 0, 90, false, paint);
    }
}
