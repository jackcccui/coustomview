package com.changpeng.coustomview.chapt_03;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;


import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.changpeng.coustomview.R;

/**
 * 版权: pengchang
 *
 * @version: 1.0
 * @author: pengchang
 * @date: 3/22/21
 * @mail: 117134581@qq.com
 * @description: LoadingImageView 上下弹跳动画
 */
public class LoadingImageView extends AppCompatImageView {


    private int mTop;
    // 当前动画图片索引
    private int mCurrentImageIndex = 0;

    // 图片总数
    private static int mTotalCount = 3;
    public LoadingImageView(Context context) {
        this(context,null);

    }

    public LoadingImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);

    }

    public LoadingImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init(){

        ValueAnimator animator = ValueAnimator.ofInt(0,100,0);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(2600);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());//设置插值器

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int  dx = (int) animation.getAnimatedValue();
                setTop(mTop-dx);
            }
        });

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                setImageDrawable(getResources().getDrawable(R.drawable.cat1));
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

                mCurrentImageIndex++;
                switch (mCurrentImageIndex%mTotalCount){
                    case 0:
                        setImageDrawable(getResources().getDrawable(R.drawable.cat1));
                        break;
                    case 1:
                        setImageDrawable(getResources().getDrawable(R.drawable.cat2));
                        break;
                    case 2:
                        setImageDrawable(getResources().getDrawable(R.drawable.cat3));
                        break;
                }

            }
        });

        animator.start();

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mTop = top;
    }
}
