package com.gink.playandroid.data.model

import com.gink.playandroid.mvvm.network.base.BaseResponse

/**
 * @author: wang-gk
 * @date:   2021/1/6
 * @desc:   服务器返回的数据基类
 */
data class ApiResponse<T>(val errorCode: Int, val errorMsg: String, val data: T) : BaseResponse<T>() {
    override fun isSucces() = errorCode == 0

    override fun getResponseData() = data

    override fun getResponseCode() = errorCode

    override fun getResponseMsg() = errorMsg
}