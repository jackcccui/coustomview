package com.changpeng.coustomview.chapt_03;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.changpeng.coustomview.R;

/**
 * 版权: pengchang
 *
 * @version: 1.0
 * @author: pengchang
 * @date: 3/24/21
 * @mail: 117134581@qq.com
 * @description: 路径动画演示
 */
public class PathAnimationActivity extends AppCompatActivity {

    private Button mBtnMenu, mBtnMenu1, mBtnMenu2, mBtnMenu3, mBtnMenu4, mBtnMenu5;
    private boolean mIsMenuOpen = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_path);

        mBtnMenu = findViewById(R.id.menu);
        mBtnMenu1 = findViewById(R.id.menu1);
        mBtnMenu2 = findViewById(R.id.menu2);
        mBtnMenu3 = findViewById(R.id.menu3);
        mBtnMenu4 = findViewById(R.id.menu4);
        mBtnMenu5 = findViewById(R.id.menu5);

        mBtnMenu.setOnClickListener((v) -> {

            if (mIsMenuOpen) {

                // closeMenu
                closeMenu();

            } else {
                // openMenu

                openMenu();


            }
            mIsMenuOpen = !mIsMenuOpen;
        });


        mBtnMenu1.setOnClickListener((v -> {
            Toast.makeText(PathAnimationActivity.this,"Oclick",Toast.LENGTH_LONG).show();
        }));

    }

    private void closeMenu() {

        closeAnimation(mBtnMenu1, 0, 5, 300);
        closeAnimation(mBtnMenu2, 1, 5, 300);
        closeAnimation(mBtnMenu3, 2, 5, 300);
        closeAnimation(mBtnMenu4, 3, 5, 300);
        closeAnimation(mBtnMenu5, 4, 5, 300);

    }


    private void openMenu() {
        openAnimation(mBtnMenu1, 0, 5, 300);
        openAnimation(mBtnMenu2, 1, 5, 300);
        openAnimation(mBtnMenu3, 2, 5, 300);
        openAnimation(mBtnMenu4, 3, 5, 300);
        openAnimation(mBtnMenu5, 4, 5, 300);

    }

    private void openAnimation(View view, int index, int total, int radius) {

        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }

        // 根据角度值获取对应的弧度值
        double degree = Math.toRadians(90) / (total - 1) * index;
        // 获取控件沿X、Y轴平移的距离
        int translationX = -(int) (radius * Math.cos(degree));
        int translationY = -(int) (radius * Math.sin(degree));

        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", 0, translationX),
                ObjectAnimator.ofFloat(view, "translationY", 0, translationY),
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
                ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
        );

        set.setDuration(1000).start();
    }

    private void closeAnimation(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }

        // 根据角度值获取对应的弧度值
        double degree = Math.toRadians(90) / (total - 1) * index;
        // 获取控件沿X、Y轴平移的距离
        int translationX = -(int) (radius * Math.cos(degree));
        int translationY = -(int) (radius * Math.sin(degree));

        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", translationX,0),
                ObjectAnimator.ofFloat(view, "translationY", translationY,0),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f),
                ObjectAnimator.ofFloat(view, "alpha", 1f, 0f)
        );

        set.setDuration(1000).start();


    }


}
