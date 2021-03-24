package com.changpeng.coustomview.chapt_03;

import android.animation.TypeEvaluator;

/**
 * 版权: pengchang
 *
 * @version: 1.0
 * @author: pengchang
 * @date: 3/23/21
 * @mail: 117134581@qq.com
 * @description: 字符估值器 从A~Z变化
 */
public class CharEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {

        int startInt = startValue;
        int endValueInt = endValue;
        int curInt = (int) (startInt + fraction*(endValueInt -startInt));
        char resut = (char) curInt;
        return resut;
    }
}
