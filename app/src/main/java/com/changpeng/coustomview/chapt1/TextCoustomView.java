package com.changpeng.coustomview.chapt1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
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
 * @description: 文字绘制基础
 */
public class TextCoustomView extends View {
    public TextCoustomView(Context context) {
        super(context);
    }

    public TextCoustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TextCoustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){


        // 基础设置
        Paint paint = new Paint();

        Typeface typeface = Typeface.defaultFromStyle(Typeface.BOLD_ITALIC); // 粗斜体
        typeface = Typeface.defaultFromStyle(Typeface.BOLD);// 粗体
        typeface = Typeface.defaultFromStyle(Typeface.ITALIC);// 斜体
        typeface = Typeface.defaultFromStyle(Typeface.NORMAL);// 正常字体
        paint.setTypeface(typeface);

        paint.setTypeface(Typeface.DEFAULT);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTypeface(Typeface.SANS_SERIF);
        paint.setTypeface(Typeface.SERIF);
        paint.setStrokeWidth(10);// 设置画笔宽度
        paint.setAntiAlias(true); // 指定是否使用抗锯齿功能 如果使用，则会使绘图速度变慢
        paint.setStyle(Paint.Style.FILL); // 绘图样式，对于文字和几何图形都有效
        paint.setTextAlign(Paint.Align.CENTER); // 设置文字对齐方式
        paint.setTextSize(12);// 设置文字大小

        // 样式设置

        paint.setFakeBoldText(true); // 设置是否是粗体文字
        paint.setUnderlineText(true); // 设置下划线
        paint.setTextSkewX((float)-0.25); // 设置文字的倾斜度，普通斜体文字为-0.25
        paint.setStrikeThruText(true); // 设置带有删除线效果

        // 其他设置

        paint.setTextScaleX(2);//只会将水平方向拉伸，高度不变


    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

       Paint paint = new Paint();
       paint.setColor(Color.RED);
       paint.setStrokeWidth(5);
       paint.setTextSize(32);
       paint.setStyle(Paint.Style.STROKE);

       // 先创建两条相同的圆形路径，并画出两条路径原形

       Path  circlePath = new Path();
       circlePath.addCircle(220,300,150, Path.Direction.CCW);// 逆向绘制

       canvas.drawPath(circlePath,paint);


       Path circlePath2 = new Path();
       circlePath2.addCircle(600,300,150, Path.Direction.CCW);

       canvas.drawPath(circlePath2,paint);

       // 绘制原始文字和偏移文字

        String str = "千里冰封，北国风光";
        paint.setColor(Color.BLUE);

        //
        canvas.drawTextOnPath(str,circlePath,0,0,paint);
        canvas.drawTextOnPath(str,circlePath2,80,30,paint);


    }
}
