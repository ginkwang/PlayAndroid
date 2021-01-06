package com.gink.playandroid.data.model

/**
 * @author: wang-gk
 * @date:   2021/1/6
 * @desc:   轮播图返回实体类
 */
data class BannerResponse(
    val data: List<Data>,
    val errorCode: Int,
    val errorMsg: String
)

data class Data(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)