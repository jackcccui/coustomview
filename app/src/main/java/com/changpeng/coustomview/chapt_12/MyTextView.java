package com.changpeng.coustomview.chapt_12;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.changpeng.coustomview.R;

/**
 * 版权:pengchang
 * 版本:1.0
 *
 * @auther: created by pengchang
 * @date: 4/9/21
 * @mail: 1171345871@qq.com
 * 描述:
 */
@SuppressLint("AppCompatCustomView")
public class MyTextView extends TextView {


    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyTextView);

        float headerHeight = array.getDimension(R.styleable.MyTextView_headerHeight,-1);
        int age = array.getInt(R.styleable.MyTextView_age,10);
        array.recycle();
        this.setText("headerHeight:"+headerHeight+"age :"+age);

    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
