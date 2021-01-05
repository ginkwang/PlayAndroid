package com.gink.playandroid.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.gink.playandroid.R
import com.gink.playandroid.databinding.ActivitySplashBinding
import com.gink.playandroid.mvvm.base.BaseActivity
import com.gink.playandroid.mvvm.base.BaseViewModel
import com.gink.playandroid.mvvm.ext.gone
import com.gink.playandroid.mvvm.ext.visible
import com.gink.playandroid.mvvm.ext.visibleOrGone
import com.gink.playandroid.ui.main.MainActivity
import com.gink.playandroid.util.CacheUtil
import com.gink.playandroid.weight.adapter.SplashBannerAdapter
import kotlinx.android.synthetic.main.activity_splash.*

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
        if (CacheUtil.isFirstOpen()) {
            splash_logo.gone()
            mDatabind.banner.apply {
                setAdapter(SplashBannerAdapter())
                setLifecycleRegistry(lifecycle)
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        tv_enter.visibleOrGone(position == (bannerTextList.size - 1))
                    }
                })
                create(bannerTextList.toList())
            }
        } else {
            splash_logo.visible()
            banner.postDelayed({
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
                //带点渐变动画
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }, 300)
        }
    }

    override fun createObserver() {
    }
}