package com.gink.playandroid.weight.banner

import android.view.View
import android.widget.TextView
import com.gink.playandroid.R
import com.zhpan.bannerview.BaseBannerAdapter
import com.zhpan.bannerview.BaseViewHolder

/**
 * @author: wang-gk
 * @date:   2021/1/4
 * @desc:
 */
class SplashBannerAdapter : BaseBannerAdapter<String, SplashBannerAdapter.BannerViewHolder>() {

    inner class BannerViewHolder(view: View) : BaseViewHolder<String>(view) {
        override fun bindData(data: String?, position: Int, pageSize: Int) {
            val textView = findView<TextView>(R.id.banner_view)
            textView.text = data
        }
    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_splash_banner
    }

    override fun createViewHolder(itemView: View, viewType: Int): BannerViewHolder {
       return BannerViewHolder(itemView)
    }

    override fun onBind(holder: BannerViewHolder?, data: String?, position: Int, pageSize: Int) {
        holder?.bindData(data, position, pageSize)
    }
}