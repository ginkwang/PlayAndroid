package com.gink.playandroid.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.gink.playandroid.R
import com.gink.playandroid.databinding.FragmentMainBinding
import com.gink.playandroid.mvvm.base.BaseFragment
import com.gink.playandroid.mvvm.ext.invisible
import com.gink.playandroid.mvvm.ext.visible
import com.gink.playandroid.ui.flow.FlowFragment
import com.gink.playandroid.ui.me.MeFragment
import com.gink.playandroid.ui.project.ProjectFragment
import com.gink.playandroid.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 * @author: wang-gk
 * @date:   2021/1/5
 * @desc:
 */
class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding>() {
    override fun layoutId(): Int {
        return R.layout.fragment_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        main_view_pager.apply {
            isUserInputEnabled = true
            offscreenPageLimit = 3
            adapter = object : FragmentStateAdapter(this@MainFragment) {
                override fun createFragment(position: Int): Fragment {
                    when (position) {
                        0 -> {
                            return FlowFragment()
                        }
                        1 -> {
                            return ProjectFragment()
                        }
                        2 -> {
                            return MeFragment()
                        }
                        else -> {
                            return FlowFragment()
                        }
                    }
                }

                override fun getItemCount() = 3
            }

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    bottom_bar.currentItem = position
                    if (position < (offscreenPageLimit - 1)) {
                        showCommonTopbar()
                    } else {
                        showMeTopbar()
                    }
                }
            })
        }

        bottom_bar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_flow -> {
                    showCommonTopbar()
                    main_view_pager.setCurrentItem(0, false)
                }
                R.id.menu_project -> {
                    showCommonTopbar()
                    main_view_pager.setCurrentItem(1, false)
                }
                R.id.menu_me -> {
                    showMeTopbar()
                    main_view_pager.setCurrentItem(2, false)
                }
            }

            true
        }
    }

    override fun createObserver() {

    }

    fun showCommonTopbar() {
        iv_left_icon.visible()
        ll_search.visible()
        iv_right_icon.invisible()
    }

    fun showMeTopbar() {
        iv_left_icon.invisible()
        ll_search.invisible()
        iv_right_icon.visible()
    }
}