package com.gink.playandroid.ui.main

import android.os.Bundle
import com.gink.playandroid.R
import com.gink.playandroid.databinding.ActivityMainBinding
import com.gink.playandroid.mvvm.base.BaseActivity
import com.gink.playandroid.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    override fun layoutId(): Int {
      return R.layout.activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {
//        appViewModel.appColor.observe(this, Observer {
//            supportActionBar?.setBackgroundDrawable(ColorDrawable(it))
//            StatusBarUtil.setColor(this, it, 0)
//        })
    }

    override fun createObserver() {

    }
}