package com.gink.playandroid.mvvm.network.base

/**
 * @author: wang-gk
 * @date:   2021/1/4
 * @desc:   服务器返回数据的基类
 */
abstract class BaseResponse<T> {
    abstract fun isSucces(): Boolean

    abstract fun getResponseData(): T

    abstract fun getResponseCode(): Int

    abstract fun getResponseMsg(): String
}