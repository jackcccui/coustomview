package com.changpeng.coustomview.chapt_04;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.changpeng.coustomview.R;

/**
 * 版权: pengchang
 *
 * @version: 1.0
 * @author: pengchang
 * @date: 3/30/21
 * @mail: 117134581@qq.com
 * @description: 带箭头的loading
 */
public class ArrowLoadingView  extends View {

    private Path mCirclePath,mDstpath;
    private Paint mPaint;
    float mCurAnimValue;
    private PathMeasure mPathMeasure;
    private Bitmap mArrawBitmap;
    private float[] pos = new float[2];
    private float[] tan = new float[2];
    public ArrowLoadingView(Context context) {
        super(context);
        init();
    }

    public ArrowLoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ArrowLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);//关闭硬件加速

        mArrawBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.awwow);// 获取本地箭头icon
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        mPaint.setColor(Color.GREEN);

        mDstpath = new Path();
        mCirclePath = new Path();

        mCirclePath.addCircle(200,200,100, Path.Direction.CW);

        mPathMeasure = new PathMeasure(mCirclePath,true); // 测量圆形路径的长度

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
        mDstpath.reset();

        mPathMeasure.getSegment(start,stop,mDstpath,true);
        canvas.drawPath(mDstpath,mPaint);

        // 旋转箭头图片并绘制
        mPathMeasure.getPosTan(stop,pos,tan);
        float degree = (float)(Math.atan2(tan[1],tan[0])*180.0/Math.PI);
        Matrix matrix = new Matrix();
        matrix.postRotate(degree,mArrawBitmap.getWidth()/2,mArrawBitmap.getHeight()/2);
        matrix.postTranslate(pos[0]-mArrawBitmap.getWidth()/2,pos[1]-mArrawBitmap.getHeight()/2);
        canvas.drawBitmap(mArrawBitmap,matrix,mPaint);
    }
}
