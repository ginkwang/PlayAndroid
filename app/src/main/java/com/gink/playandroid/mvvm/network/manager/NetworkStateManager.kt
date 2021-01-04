package com.gink.playandroid.mvvm.network.manager

import com.kunminx.architecture.ui.callback.UnPeekLiveData

/**
 * @author: wang-gk
 * @date:   2021/1/4
 * @desc:   网络变化管理者
 */
class NetworkStateManager private constructor() {
    val mNetworkStateCallback = UnPeekLiveData<NetState>()

    companion object {
        val instance: NetworkStateManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetworkStateManager()
        }
    }
}