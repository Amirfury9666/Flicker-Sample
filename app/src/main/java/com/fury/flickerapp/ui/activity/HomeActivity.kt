package com.fury.flickerapp.ui.activity

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.fury.flickerapp.data.viewmodel.FeedViewModel
import com.fury.flickerapp.R
import com.fury.flickerapp.base.core.ViewModelFactory
import com.fury.flickerapp.adapter.ViewPageAdapter
import com.fury.flickerapp.base.core.BaseActivity
import com.fury.flickerapp.databinding.ActivityHomeBinding
import com.fury.flickerapp.ui.fragment.FeedFragment
import com.fury.flickerapp.utility.Constants
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

const val tag = "tag"
class HomeActivity : BaseActivity<ActivityHomeBinding>(),KodeinAware {

    override val kodein by kodein()
    private val viewModelFactory : ViewModelFactory by instance()
    private lateinit var feedsViewModel : FeedViewModel

    override val layoutResId: Int get() = R.layout.activity_home
    override fun getToolBar(binding: ActivityHomeBinding): Toolbar? {return null}

    override fun onActivityReady(instance: Bundle?, binding: ActivityHomeBinding) {
        setToolbarTitle("Flicker Feeds")

        feedsViewModel = ViewModelProviders.of(this,viewModelFactory).get(FeedViewModel::class.java)
        val adapter = ViewPageAdapter(supportFragmentManager)
        adapter.addFragment(FeedFragment.getNewInstance(Constants.TAG_BIRDS),getString(R.string.bird))
        adapter.addFragment(FeedFragment.getNewInstance(Constants.TAG_CATS),getString(R.string.cat))
        adapter.addFragment(FeedFragment.getNewInstance(Constants.TAG_DOGS),getString(R.string.dog))

        binding.viewPager.adapter = adapter
        binding.tagLayout.setupWithViewPager(binding.viewPager)
    }



}
