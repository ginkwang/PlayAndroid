package com.gink.playandroid.mvvm.base

import androidx.lifecycle.ViewModel
import com.kunminx.architecture.ui.callback.UnPeekLiveData

/**
 * @author: wang-gk
 * @date:   2021/1/4
 * @desc:   ViewModel 基类
 */
open class BaseViewModel : ViewModel(){

    val loadingChange: UILoadingChange by lazy { UILoadingChange() }

    /**
     * 通知UI层显隐加载框
     */
    inner class UILoadingChange {
        // 显示加载框
        val showLoadingDialog by lazy { UnPeekLiveData<String>() }

        // 隐藏加载框
        val hideLoadingDialog by lazy { UnPeekLiveData<Boolean>() }
    }
}