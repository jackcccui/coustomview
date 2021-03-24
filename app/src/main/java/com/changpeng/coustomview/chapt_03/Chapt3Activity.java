package com.changpeng.coustomview.chapt_03;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.changpeng.coustomview.R;

/**
 * 版权: pengchang
 *
 * @version: 1.0
 * @author: pengchang
 * @date: 3/22/21
 * @mail: 117134581@qq.com
 * @description: 属性动画
 */
public class Chapt3Activity extends AppCompatActivity {
    private Button mBtn;
    private TextView mTxt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chapt3);
        mBtn = findViewById(R.id.btn);
        mTxt = findViewById(R.id.txt);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                doValueAnimator();
//                doValueCharAnimator();
                objectAnimator();
            }
        });

    }

    /**
     *  属性动画 valueAnimator
     */
    private void doValueAnimator(){
        ValueAnimator animator = ValueAnimator.ofInt(0,400);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                mTxt.setText(curValue+"当前值");
                mTxt.layout(curValue,curValue,curValue+mTxt.getWidth(),curValue+mTxt.getHeight());

            }
        });

        animator.setDuration(3000);
        animator.setEvaluator(new ReverseEvaluator());
        animator.start();

    }

    /**
     *  从字符A到Z变化
     */
    private void doValueCharAnimator(){
        ValueAnimator animator = ValueAnimator.ofObject(new CharEvaluator(),new Character('A'),new Character('Z'));
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char curValue = (Character)animation.getAnimatedValue();
                mTxt.setText(animation.getAnimatedValue()+"当前值");
                mTxt.layout(curValue,curValue,curValue+mTxt.getWidth(),curValue+mTxt.getHeight());

            }
        });

        animator.setDuration(3000);
        animator.setEvaluator(new CharEvaluator());
        animator.start();

    }


    private void objectAnimator(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTxt,"rotation",0,90,160,0);
        animator.setDuration(3000);
        animator.start();
    }
}
