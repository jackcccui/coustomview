package com.changpeng.coustomview.chapter_02_demo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.changpeng.coustomview.R;

/**
 * 版权: pengchang
 *
 * @version: 1.0
 * @author: pengchang
 * @date: 3/19/21
 * @mail: 117134581@qq.com
 * @description: 几种动画效果实现
 */
public class ViewAnimationDemoActivity extends AppCompatActivity {
    Button mBtn;
    TextView mTxt;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation_deom);
        mBtn = findViewById(R.id.btn);
        mTxt = findViewById(R.id.txt);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setScaleAnimation();
            }
        });
    }


    /**
     * 镜头由远及近效果
     */
    private void setScaleAnimation(){

        ScaleAnimation animation = new ScaleAnimation(1.0f,1.5f,1.0f,1.5f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setFillAfter(true);
        animation.setDuration(6000);
        animation.setInterpolator(new BounceInterpolator());
        mTxt.startAnimation(animation);

    }

    /**
     * 自定义loading框
     */
    private void coustomLoadingView(){


    }
}
