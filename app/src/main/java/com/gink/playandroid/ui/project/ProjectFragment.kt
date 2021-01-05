package com.gink.playandroid.ui.project

import android.os.Bundle
import com.gink.playandroid.R
import com.gink.playandroid.databinding.FragmentFlowBinding
import com.gink.playandroid.databinding.FragmentProjectBinding
import com.gink.playandroid.mvvm.base.BaseFragment
import com.gink.playandroid.viewmodel.FlowViewModel
import com.gink.playandroid.viewmodel.ProjectViewModel

/**
 * @author: wang-gk
 * @date:   2021/1/5
 * @desc:
 */
class ProjectFragment : BaseFragment<ProjectViewModel, FragmentProjectBinding>() {
    override fun layoutId(): Int {
        return R.layout.fragment_project
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun createObserver() {
    }
}