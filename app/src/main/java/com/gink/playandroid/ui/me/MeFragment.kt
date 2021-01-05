package com.gink.playandroid.ui.me

import android.os.Bundle
import com.gink.playandroid.R
import com.gink.playandroid.databinding.FragmentFlowBinding
import com.gink.playandroid.databinding.FragmentMeBinding
import com.gink.playandroid.mvvm.base.BaseFragment
import com.gink.playandroid.viewmodel.FlowViewModel
import com.gink.playandroid.viewmodel.MeViewModel

/**
 * @author: wang-gk
 * @date:   2021/1/5
 * @desc:
 */
class MeFragment : BaseFragment<MeViewModel, FragmentMeBinding>() {
    override fun layoutId(): Int {
        return R.layout.fragment_me
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun createObserver() {
    }
}