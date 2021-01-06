package com.gink.playandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import com.gink.playandroid.data.model.BannerResponse
import com.gink.playandroid.mvvm.base.BaseViewModel
import com.gink.playandroid.mvvm.network.base.BaseRequest

/**
 * @author: wang-gk
 * @date:   2021/1/5
 * @desc:   知识流viewmodel
 */
class FlowViewModel : BaseViewModel() {
    val bannerData: MutableLiveData<BaseRequest<ArrayList<BannerResponse>>> = MutableLiveData()

//    fun getBanner() {
//        request({api})
//    }
}