package com.changpeng.coustomview.chapt_04;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 版权: pengchang
 *
 * @version: 1.0
 * @author: pengchang
 * @date: 3/26/21
 * @mail: 117134581@qq.com
 * @description: 高级动画demo
 */
public class PathAnimationView extends View {
    public PathAnimationView(Context context) {
        super(context);
    }

    public PathAnimationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PathAnimationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        Path path = new Path();
        path.addRect(50,50,100,100,Path.Direction.CW);
        Path dst = new Path();
        dst.lineTo(10,100);
        PathMeasure measure = new PathMeasure(path,true);
        measure.getSegment(0,100,dst,false);
        canvas.drawPath(dst,paint);

    }
}
