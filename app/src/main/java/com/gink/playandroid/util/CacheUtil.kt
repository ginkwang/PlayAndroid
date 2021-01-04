package com.gink.playandroid.util

import com.tencent.mmkv.MMKV

object CacheUtil {

    private const val MMKV_ID = "PLAY_ANDROID";

    /**
     * 是否首次启动
     */
    fun isFirstOpen(): Boolean {
        val kv = MMKV.mmkvWithID(MMKV_ID)
        return kv.decodeBool("first_open", true)
    }

    /**
     * 设置是否首次启动
     */
    fun setFirstOpen(first: Boolean): Boolean {
        val kv = MMKV.mmkvWithID(MMKV_ID)
        return kv.encode("first_open", first)
    }

//    /**
//     * 获取保存的账户信息
//     */
//    fun getUser(): UserInfo? {
//        val kv = MMKV.mmkvWithID("app")
//        val userStr = kv.decodeString("user")
//        return if (TextUtils.isEmpty(userStr)) {
//           null
//        } else {
//            Gson().fromJson(userStr, UserInfo::class.java)
//        }
//    }
//
//    /**
//     * 设置账户信息
//     */
//    fun setUser(userResponse: UserInfo?) {
//        val kv = MMKV.mmkvWithID("app")
//        if (userResponse == null) {
//            kv.encode("user", "")
//            setIsLogin(false)
//        } else {
//            kv.encode("user", Gson().toJson(userResponse))
//            setIsLogin(true)
//        }
//
//    }

//    /**
//     * 是否已经登录
//     */
//    fun isLogin(): Boolean {
//        val kv = MMKV.mmkvWithID("app")
//        return kv.decodeBool("login", false)
//    }
//
//    /**
//     * 设置是否已经登录
//     */
//    fun setIsLogin(isLogin: Boolean) {
//        val kv = MMKV.mmkvWithID("app")
//        kv.encode("login", isLogin)
//    }

//    /**
//     * 首页是否开启获取指定文章
//     */
//    fun isNeedTop(): Boolean {
//        val kv = MMKV.mmkvWithID("app")
//        return kv.decodeBool("top", true)
//    }
//    /**
//     * 设置首页是否开启获取指定文章
//     */
//    fun setIsNeedTop(isNeedTop:Boolean): Boolean {
//        val kv = MMKV.mmkvWithID("app")
//        return kv.encode("top", isNeedTop)
//    }
//    /**
//     * 获取搜索历史缓存数据
//     */
//    fun getSearchHistoryData(): ArrayList<String> {
//        val kv = MMKV.mmkvWithID("cache")
//        val searchCacheStr =  kv.decodeString("history")
//        if (!TextUtils.isEmpty(searchCacheStr)) {
//            return Gson().fromJson(searchCacheStr
//                , object : TypeToken<ArrayList<String>>() {}.type)
//        }
//        return arrayListOf()
//    }
//
//    fun setSearchHistoryData(searchResponseStr: String) {
//        val kv = MMKV.mmkvWithID("cache")
//        kv.encode("history",searchResponseStr)
//    }
}