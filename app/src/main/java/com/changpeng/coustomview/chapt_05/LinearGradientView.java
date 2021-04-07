package com.changpeng.coustomview.chapt_05;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 版权:pengchang
 * 版本:1.0
 *
 * @auther: created by pengchang
 * @date: 4/7/21
 * @mail: 1171345871@qq.com
 * 描述: 渐变色控件
 */
public class LinearGradientView extends View {

    private Paint mPaint;
    public LinearGradientView(Context context) {
        super(context);
        initParams();

    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initParams();

    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initParams();
    }


    private void initParams() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setShader(new LinearGradient(0,getHeight()/2,getWidth(),getHeight()/2,0xfff0000,0xff00ff00, Shader.TileMode.CLAMP));
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);

    }
}
