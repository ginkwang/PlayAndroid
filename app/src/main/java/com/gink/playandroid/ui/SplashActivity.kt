package com.gink.playandroid.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.blankj.utilcode.util.ActivityUtils.startActivity
import com.gink.playandroid.R
import com.gink.playandroid.databinding.ActivitySplashBinding
import com.gink.playandroid.mvvm.base.BaseActivity
import com.gink.playandroid.mvvm.base.BaseViewModel
import com.gink.playandroid.util.CacheUtil
import com.gink.playandroid.weight.banner.SplashBannerAdapter
import com.zhpan.bannerview.BannerViewPager

class SplashActivity : BaseActivity<BaseViewModel, ActivitySplashBinding>() {

    inner class ProxyClick {
        fun toMain() {
            CacheUtil.setFirstOpen(false)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
            //带点渐变动画
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }

    private var bannerTextList = arrayOf("来了老弟", "我大E了啊", "这好吗？这不好！", "好自为之")

    override fun layoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initView(savedInstanceState: Bundle?) {
        //防止出现按Home键回到桌面时，再次点击重新进入该界面bug
        if (intent.flags and Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT !== 0) {
            finish()
            return
        }
        mDatabind.click = ProxyClick()
        mDatabind.banner.apply {
            setAdapter(SplashBannerAdapter())
            setLifecycleRegistry(lifecycle)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                }
            })
            create(bannerTextList.toList())
        }

    }

    override fun createObserver() {
    }
}