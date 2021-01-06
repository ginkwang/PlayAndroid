package com.gink.playandroid.mvvm.network

import com.gink.playandroid.data.model.ApiResponse
import com.gink.playandroid.data.model.BannerResponse
import retrofit2.http.GET

/**
 * @author: wang-gk
 * @date:   2021/1/6
 * @desc:   API
 */
interface ApIService {
    companion object {
        const val SERVER_URL = "https://wanandroid.com/"
    }

    /**
     * 获取banner数据
     */
    @GET("banner/json")
    suspend fun getBanner(): ApiResponse<ArrayList<BannerResponse>>

}