package com.gink.playandroid.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.gink.playandroid.R
import com.gink.playandroid.databinding.FragmentMainBinding
import com.gink.playandroid.mvvm.base.BaseFragment
import com.gink.playandroid.ui.flow.FlowFragment
import com.gink.playandroid.ui.me.MeFragment
import com.gink.playandroid.ui.project.ProjectFragment
import com.gink.playandroid.viewmodel.MainViewModel

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
        mDatabind.mainViewPager.apply {
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
                    Log.i("OnPageChangeCallback", "onPageSelected: " + position)
                    mDatabind.bottomBar.currentItem = position
                }
            })
        }

        mDatabind.bottomBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_flow -> mDatabind.mainViewPager.setCurrentItem(0, false)
                R.id.menu_project -> mDatabind.mainViewPager.setCurrentItem(1, false)
                R.id.menu_me -> mDatabind.mainViewPager.setCurrentItem(2, false)
            }

            true
        }
    }

    override fun createObserver() {

    }
}