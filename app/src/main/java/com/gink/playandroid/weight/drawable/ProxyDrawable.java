package com.gink.playandroid.weight.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/**
 * @author: wang-gk
 * @date:   2021/1/4
 * @desc:   布局文件中对任意View声明drawable属性
 * 使用DataBinding时强烈推荐该库 https://github.com/whataa/noDrawable
 * 只需要复制核心类 ProxyDrawable，Drawables至项目中即可
 * 可以减少大量的drawable.xml文件，很香
 */
public class ProxyDrawable extends StateListDrawable {

    private Drawable originDrawable;

    @Override
    public void addState(int[] stateSet, Drawable drawable) {
        if (stateSet != null && stateSet.length == 1 && stateSet[0] == 0) {
            originDrawable = drawable;
        }
        super.addState(stateSet, drawable);
    }

    Drawable getOriginDrawable() {
        return originDrawable;
    }
}
