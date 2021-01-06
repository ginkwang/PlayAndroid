package com.gink.playandroid.mvvm.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gink.playandroid.mvvm.network.base.BaseRequest
import com.gink.playandroid.mvvm.network.base.BaseResponse
import com.gink.playandroid.mvvm.network.base.paresException
import com.gink.playandroid.mvvm.network.base.paresResult
import com.kunminx.architecture.ui.callback.UnPeekLiveData
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

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

    fun <T> request(
        block: suspend () -> BaseResponse<T>,
        resultState: MutableLiveData<BaseRequest<T>>,
        isShowDialog: Boolean = false,
        loadingMessage: String = "请求网络中..."
    ): Job {
        return viewModelScope.launch {
            runCatching {
                if (isShowDialog) resultState.value = BaseRequest.onLoading(loadingMessage)
                //请求体
                block()
            }.onSuccess {
                resultState.paresResult(it)
            }.onFailure {
                Log.e("TAG", "request: " + it.message)
//                it.message?.
                resultState.paresException(it)
            }
        }
    }
}