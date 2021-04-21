package com.changpeng.coustomview.chapt_06;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
 * 描述: 使用Bitmap 创建canvas对象
 */
public class BitmapCanvasView extends View {

    private Bitmap mBitmap;
    private Paint mPaint;
    private Canvas mBitmapCanvas;

    public BitmapCanvasView(Context context) {
        super(context);
        initParams();
    }

    public BitmapCanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initParams();
    }

    public BitmapCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initParams();
    }
    private void initParams(){
        mBitmap = Bitmap.createBitmap(500,500,Bitmap.Config.ARGB_8888); //创建一个画布
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mBitmapCanvas = new Canvas(mBitmap);// 此Canvas作用在bitmap上 canvas所画的图像都显示在Bitmap上，并不作用在View上

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setTextSize(66);
        mBitmapCanvas.drawText("Hello Android",0,100,mPaint);// 这个mBitmapCanvas是在mBitmap上渲染图片
        canvas.drawBitmap(mBitmap,0,0,mPaint);// 只用onDraw(Canvas canvas)中的canvas所画的图片才会显示在View上
    }
}
