package com.gink.playandroid.ui.flow

import android.os.Bundle
import android.util.Log
import com.gink.playandroid.R
import com.gink.playandroid.databinding.FragmentFlowBinding
import com.gink.playandroid.mvvm.base.BaseFragment
import com.gink.playandroid.viewmodel.FlowViewModel

/**
 * @author: wang-gk
 * @date:   2021/1/5
 * @desc:   知识流fragment
 */
class FlowFragment : BaseFragment<FlowViewModel, FragmentFlowBinding>() {
    override fun layoutId(): Int {
        return R.layout.fragment_flow
    }

    override fun initView(savedInstanceState: Bundle?) {
        Log.i("FlowFragment", "initView: ")
    }

    override fun createObserver() {
    }

    override fun onResume() {
        super.onResume()
        Log.i("FlowFragment", "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("FlowFragment", "onPause: ")
    }
}