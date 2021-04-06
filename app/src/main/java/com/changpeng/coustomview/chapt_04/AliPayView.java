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
 * @date: 3/31/21
 * @mail: 117134581@qq.com
 * @description: 支付宝支付成功动画
 */
public class AliPayView extends View {
    private Paint mPaint;
    private Path mDstPath,mCirclePath;
    private float mCentX,mCentY,mRadius,mCurAnimValue;
    private PathMeasure mPathMeasure;
    public AliPayView(Context context) {
        super(context);
        init();
    }

    public AliPayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AliPayView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }



    private void init() {

        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mCentX = 200;
        mCentY = 200;
        mRadius = 100;
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);

        mDstPath = new Path(); // 圆形 路径
        mCirclePath = new Path(); // ✅ 路径

        mCirclePath.addCircle(mCentX,mCentY,mRadius, Path.Direction.CW); // 勾勒一个圆

        mCirclePath.moveTo(mCentX - mRadius/2,mCentY);
        mCirclePath.lineTo(mCentX,mCentY+mRadius/2);
        mCirclePath.lineTo(mCentX+mRadius/2,mCentY-mRadius/3);

        mPathMeasure = new PathMeasure(mCirclePath,false);

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,2);

        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurAnimValue = (float) animation.getAnimatedValue();
                invalidate();
            }
        });

        valueAnimator.setDuration(1000);
        valueAnimator.start();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);
        if (mCurAnimValue<1){
            float stop = mPathMeasure.getLength()*mCurAnimValue;
            mPathMeasure.getSegment(0,stop,mDstPath,true);
        }else if (mCurAnimValue == 1){
            mPathMeasure.getSegment(0,mPathMeasure.getLength(),mDstPath,true);
            mPathMeasure.nextContour();
        }else {
            float stop = mPathMeasure.getLength()*(mCurAnimValue-1);
            mPathMeasure.getSegment(0,stop,mDstPath,true);
        }

        canvas.drawPath(mDstPath,mPaint);

    }
}
