package com.changpeng.coustomview.chapt1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 版权: pengchang
 *
 * @version: 1.0
 * @author: pengchang
 * @date: 3/12/21
 * @mail: 117134581@qq.com
 * @description: 弧形Path Demo
 */
public class OvalPathView extends View {
    public OvalPathView(Context context) {
        super(context);
    }

    public OvalPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OvalPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        Path path =new Path();
        path.moveTo(100,100);
        RectF rectF = new RectF(150,100,200,150);
        path.arcTo(rectF,0,90);
        canvas.drawPath(path,paint);
    }
}
