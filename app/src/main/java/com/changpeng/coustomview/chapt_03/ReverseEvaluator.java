package com.changpeng.coustomview.chapt_03;

import android.animation.TypeEvaluator;

/**
 * 版权: pengchang
 *
 * @version: 1.0
 * @author: pengchang
 * @date: 3/23/21
 * @mail: 117134581@qq.com
 * @description: 自定义倒叙估值器
 */
public class ReverseEvaluator implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        return (int)(endValue-fraction*(endValue-startValue));
    }
}
