package com.changpeng.coustomview.chapt1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 版权: pengchang
 *
 * @version: 1.0
 * @author: pengchang
 * @date: 3/15/21
 * @mail: 117134581@qq.com
 * @description: 蜘蛛网
 */
public class SpiderView extends View {

    private Paint radarPaint,valuePaint;
    private float radius;//雷达的最大半径
    private int centerX; // 中心X
    private int centerY; // 中心Y

    int count = 6; // 六条边
    double angle = Math.PI/3; // 每个拐点的角度是60度
    public SpiderView(Context context) {
        super(context);
        init();
    }

    public SpiderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SpiderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        radarPaint = new Paint();
        radarPaint.setStyle(Paint.Style.STROKE);
        radarPaint.setColor(Color.RED);

        valuePaint = new Paint();
        valuePaint.setStyle(Paint.Style.FILL);
        valuePaint.setColor(Color.BLUE);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        // 将雷达的总大小设置成当前控件的90% ，所以将半径设置成以下值
        radius = Math.min(h,w)/2*0.9f;
        // 中心坐标
        centerX = w/2;
        centerY = h/2;
        postInvalidate();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPolygon(canvas);
        drawLine(canvas);
        drawDataMap(canvas);
    }

    /***
     * 画一个蜘蛛网 正六边形
     * @param canvas
     */
    private void drawPolygon(Canvas canvas){


        Path path = new Path();
        float r = radius/ count; // 蜘蛛丝之间的间距

        for (int i =1; i<=count;i++){ // 中心点不用绘制  画6个正六边形
            float curR = r*i; // 当前半径
            path.reset();
            for (int j=0;j<count;j++){ // 画每一个正六边形的拐点
                if (j==0){
                    path.moveTo(centerX+curR,centerY);
                }else {
                    float x = (float)(centerX+curR*Math.cos(angle*j));
                    float y = (float)(centerY+curR*Math.sin(angle*j));
                    path.lineTo(x,y);
                }
            }
            path.close();

            canvas.drawPath(path,radarPaint);

        }

    }


    /**
     * 画网格中线
     */

    private void drawLine(Canvas canvas){

        Path path = new Path();
        for (int i = 0; i < count ; i++) {
            path.reset();
            path.moveTo(centerX,centerY);

            float x = (float)(centerX+radius*Math.cos(angle*i));
            float y = (float)(centerY+radius*Math.sin(angle*i));
            path.lineTo(x,y);
            canvas.drawPath(path,radarPaint);
        }

    }
    
    
    // 数据
    private double[] data ={1,5,1,6,4,5};
    // 最大值
    private float maxValue = 6;
    

    /**
     * 画数据填充
     */
    
    private void drawDataMap(Canvas canvas){
        
        Path path = new Path();
        valuePaint.setAlpha(127);

        for (int i = 0; i < count; i++) {
            double precent = data[i]/maxValue;
            float x = (float)(centerX+radius*Math.cos(angle*i)*precent);
            float y = (float)(centerY+radius*Math.sin(angle*i)*precent);
            if (i==0){
                path.moveTo(x,centerY);
            }else {
                path.lineTo(x,y);
            }
            canvas.drawCircle(x,y,10,valuePaint);


        }

        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path,valuePaint);
        
        
    }
}
