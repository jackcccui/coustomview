package com.changpeng.coustomview.chapt_06;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 版权:pengchang
 * 版本:1.0
 *
 * @auther: created by pengchang
 * @date: 4/8/21
 * @mail: 1171345871@qq.com
 * 描述:
 */
public class CoostomView extends View {

    private int with = 400;
    private int height = 400;
    private Bitmap dstBitmap,srcBitmap;
    private Paint mPaint;

    public CoostomView(Context context) {
        super(context);
        initParams();
    }

    public CoostomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initParams();
    }

    public CoostomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initParams();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);
        int layId = canvas.saveLayer(0,0,with*2,height*2,mPaint,Canvas.ALL_SAVE_FLAG);

        canvas.drawBitmap(dstBitmap,0,0,mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(srcBitmap,with/2,height/2,mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(layId);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    private void initParams(){
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);//关闭硬件加速
        srcBitmap = makeSrc(with,height);
        dstBitmap = makeDst(with,height);
        mPaint = new Paint();
    }

    // 创建一张圆形图片
    private Bitmap makeDst(int w,int h){
        Bitmap bm =Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.BLUE);
        canvas.drawOval(new RectF(0,0,w,h),p);
        return bm;
    }

    // 创建一张矩形图片
    private Bitmap makeSrc(int w,int h){
        Bitmap bm =Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.RED);
        canvas.drawRect(0,0,w,h,p);
        return bm;
    }
}
