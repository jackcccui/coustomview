package com.changpeng.coustomview.chapt_02;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.changpeng.coustomview.R;

/**
 * 版权: pengchang
 *
 * @version: 1.0
 * @author: pengchang
 * @date: 3/16/21
 * @mail: 117134581@qq.com
 * @description: xml 动画文件配置
 */
public class ViewAnimationActivity extends AppCompatActivity {
    Button mBtn;
    TextView mTxt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation_xml);

        mBtn = findViewById(R.id.btn);
        mTxt = findViewById(R.id.txt);
//        setScaleAnimation();
//        setAlphaAnimation();
//        setRotateAnimation();
//        setTranslateAnimation();
//        setAnimation();
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setScaleAnimation(0);
//                setTranslateAnimation();
//                setAlphaAnimationCode();
//                setRotateAnimationCode();
                setTranslateAnimationCode();
//                animationSet();
            }
        });


    }


    /**
     * 缩放动画
     */
    private void setScaleAnimation() {
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.scaleanim);
                mBtn.startAnimation(animation);
            }
        });
    }

    /**
     * 透明度动画
     */
    private void setAlphaAnimation() {
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.alphaanim);
                mBtn.startAnimation(animation);
            }
        });
    }

    /**
     * 旋转动画
     */
    private void setRotateAnimation() {
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.rotateanim);
                mBtn.startAnimation(animation);
            }
        });
    }

    /**
     * 平移动画
     */
    private void setTranslateAnimation() {
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.tranlateanim);
                mBtn.startAnimation(animation);
            }
        });
    }

    /**
     * 动画集合
     */
    private void setAnimation() {
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this, R.anim.setanim);
                mBtn.startAnimation(animation);
            }
        });
    }


    /**
     * 代码实现缩放动画
     *
     * @param flag 无任何意义
     */
    private void setScaleAnimation(int flag) {

        ScaleAnimation scaleAnimation =
                new ScaleAnimation(
                        0.0f,
                        1.5f,
                        0.5f,
                        2.0f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f,
                        Animation.RELATIVE_TO_SELF,
                        0.5f);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setFillBefore(true);
        mBtn.setAnimation(scaleAnimation);
        mTxt.setAnimation(scaleAnimation);
        mTxt.startAnimation(scaleAnimation);

    }

    /**
     * 代码实现 透明度动画
     */
    private void setAlphaAnimationCode() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setFillBefore(true);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        mTxt.startAnimation(alphaAnimation);

    }

    /**
     * 旋转动画
     */
    private void setRotateAnimationCode() {

        RotateAnimation rotateAnimation = new RotateAnimation(
                0,
                180,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f);
        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillBefore(true);
        mTxt.setAnimation(rotateAnimation);
        mTxt.startAnimation(rotateAnimation);
    }

    /**
     * 平移动画
     */
    private void setTranslateAnimationCode() {
        TranslateAnimation animation = new TranslateAnimation(
                Animation.ABSOLUTE,
                0,
                Animation.ABSOLUTE,
                90,
                Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, 0);
        animation.setDuration(3000);
        animation.setFillBefore(true);
        animation.setInterpolator(new LinearInterpolator()); // 线性插值器，即匀速加速器
        animation.setInterpolator(new AccelerateInterpolator()); // 刚开始速率比较慢，然后开始加速
        animation.setInterpolator(new AccelerateDecelerateInterpolator()); // 刚开始速率快，然后开始变慢
        animation.setInterpolator(new DecelerateInterpolator()); // 减速插值器，动画一开始的瞬间加速到最大值，然后逐渐变慢
        animation.setInterpolator(new BounceInterpolator());// 弹跳插值器，模拟了控件自由落地后的回弹效果，类似皮球落地后回弹的效果
        animation.setInterpolator(new AnticipateInterpolator());// 初始偏移插值器 表示动画开始的时候向前偏移一段距离，然后应用动画
        animation.setInterpolator(new OvershootInterpolator()); // 结束偏移插值器 表示动画结束的时候继续向动画方向偏移一段距离
        animation.setInterpolator(new AnticipateOvershootInterpolator());// 在动画开始时向前偏移一段距离，在动画结束后向后偏移一段距离
        animation.setInterpolator(new CycleInterpolator(2)); // 循环插值器。参数表示循环次数
        mTxt.setAnimation(animation);
        mTxt.startAnimation(animation);

    }

    private void animationSet() {
        AnimationSet set = new AnimationSet(true);

        RotateAnimation rotateAnimation = new RotateAnimation(
                0,
                180,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f);

        TranslateAnimation animation = new TranslateAnimation(
                Animation.ABSOLUTE,
                0,
                Animation.ABSOLUTE,
                -180,
                Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, 180);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);

        set.addAnimation(alphaAnimation);
        set.addAnimation(rotateAnimation);
        set.addAnimation(animation);
        set.setDuration(3000);
        set.setFillAfter(true);
        mTxt.startAnimation(set);

    }
}
