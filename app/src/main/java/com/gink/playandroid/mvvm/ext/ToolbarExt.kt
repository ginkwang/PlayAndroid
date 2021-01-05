package com.gink.playandroid.mvvm.ext

import androidx.appcompat.widget.Toolbar
import com.blankj.utilcode.util.Utils
import com.gink.playandroid.util.SettingUtil

/**
 * @author: wang-gk
 * @date:   2021/1/5
 * @desc:   Toolbar扩展函数
 */
fun Toolbar.initCustomToolbar(titleText : String = "") : Toolbar {
    setBackgroundColor(SettingUtil.getColor(Utils.getApp()))
    title = titleText
    return this
}