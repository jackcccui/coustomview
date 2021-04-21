package com.changpeng.coustomview.chapt_12;



import android.content.res.Resources;
import android.util.TypedValue;

/**
 * @auther: created by pengchang
 * @date: 4/12/21
 * @mail: 1171345871@qq.com
 * 描述:像素密度计算工具
 */
@SuppressWarnings("unused")
public class DensityUtil {

    public float density;

    public DensityUtil() {
        density = Resources.getSystem().getDisplayMetrics().density;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     * @param dpValue 虚拟像素
     * @return 像素
     */
    public static int dp2px(float dpValue) {
        return (int) (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpValue, Resources.getSystem().getDisplayMetrics());
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     * @param pxValue 像素
     * @return 虚拟像素
     */
    public static float px2dp( float pxValue) {
        final float scale =Resources.getSystem().getDisplayMetrics().density;
        return (pxValue / scale);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     * @param pxValue 像素
     * @return 虚拟像素
     */
    public float px2dip(int pxValue) {
        return (pxValue / Resources.getSystem().getDisplayMetrics().scaledDensity);
    }

    /**
     * 根据手机的分辨率从 sp(像素) 的单位 转成为 px
     * @param sp 像素
     * @return 虚拟像素
     */
    public static float sp2px( float sp){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                sp, Resources.getSystem().getDisplayMetrics());
    }
}
