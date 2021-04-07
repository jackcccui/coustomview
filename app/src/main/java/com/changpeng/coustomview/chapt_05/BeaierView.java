package com.changpeng.coustomview.chapt_05;

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
 * @date: 4/6/21
 * @mail: 1171345871@qq.com
 * 描述:
 */
public class BeaierView extends View {
    public BeaierView(Context context) {
        super(context);
    }

    public BeaierView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BeaierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        Path path = new Path();
        path.moveTo(100,300);
        path.quadTo(200,200,300,300);
        path.quadTo(400,400,500,300);
        canvas.drawPath(path,paint);
    }
}
