package com.gink.playandroid.mvvm.network.base

import androidx.lifecycle.MutableLiveData
import com.gink.playandroid.mvvm.network.handle.AppException
import com.gink.playandroid.mvvm.network.handle.ExceptionHandle

/**
 * @author: wang-gk
 * @date:   2021/1/4
 * @desc:   自定义请求封装类
 */
sealed class BaseRequest<out T> {
    companion object {
        fun <T> onSuccess(data: T): BaseRequest<T> =
            Success(data)
        fun <T> onLoading(loadingMessage:String): BaseRequest<T> =
            Loading(
                loadingMessage
            )
        fun <T> onError(error: AppException): BaseRequest<T> =
            Error(error)
    }

    data class Loading(val loadingMessage:String) : BaseRequest<Nothing>()
    data class Success<out T>(val data: T) : BaseRequest<T>()
    data class Error(val error: AppException) : BaseRequest<Nothing>()
}

/**
 * 处理返回值
 * @param result 请求结果
 */
fun <T> MutableLiveData<BaseRequest<T>>.paresResult(result: BaseResponse<T>) {
    value = when {
        result.isSucces() -> {
            BaseRequest.onSuccess(
                result.getResponseData()
            )
        }
        else -> {
            BaseRequest.onError(
                AppException(
                    result.getResponseCode(),
                    result.getResponseMsg()
                )
            )
        }
    }
}

/**
 * 不处理返回值 直接返回请求结果
 * @param result 请求结果
 */
fun <T> MutableLiveData<BaseRequest<T>>.paresResult(result: T) {
    value =
        BaseRequest.onSuccess(
            result
        )
}

/**
 * 异常转换异常处理
 */
fun <T> MutableLiveData<BaseRequest<T>>.paresException(e: Throwable) {
    this.value =
        BaseRequest.onError(
            ExceptionHandle.handleException(e)
        )
}