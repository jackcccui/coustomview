package com.changpeng.coustomview.chapt_04;

import android.animation.ValueAnimator;
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
 * @date: 3/29/21
 * @mail: 117134581@qq.com
 * @description: 圆形动画 Loading
 */
public class CircleSegmentView  extends View {
    Paint mPaint;
    Path mDst,mCirlclePath;
    PathMeasure mPathMeasure;
    float mCurAnimValue;
    public CircleSegmentView(Context context) {
        super(context);
        init();
    }

    public CircleSegmentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleSegmentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        setLayerType(LAYER_TYPE_SOFTWARE,null);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        mPaint.setColor(Color.GREEN);

        mDst = new Path();
        mCirlclePath = new Path();

        mCirlclePath.addCircle(100,100,50, Path.Direction.CW);

        mPathMeasure = new PathMeasure(mCirlclePath,true); // 测量圆形路径的长度

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,1);

        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurAnimValue = (float) animation.getAnimatedValue();
                invalidate();
            }
        });

        valueAnimator.setDuration(2000);
        valueAnimator.start();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);
        float length = mPathMeasure.getLength();
        float stop = mPathMeasure.getLength()*mCurAnimValue;

        float start = (float) (stop-((0.5-Math.abs(mCurAnimValue-0.5))*length));
        mDst.reset();

        mPathMeasure.getSegment(start,stop,mDst,true);
        canvas.drawPath(mDst,mPaint);
    }
}
