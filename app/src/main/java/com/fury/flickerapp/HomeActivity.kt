package com.fury.flickerapp

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fury.flickerapp.base.BaseActivity
import com.fury.flickerapp.base.network.ConnectivityInterceptorImpl
import com.fury.flickerapp.base.network.ServiceGenerator
import com.fury.flickerapp.databinding.ActivityHomeBinding
import com.fury.flickerapp.datasource.FlickerDataSourceImpl
import com.fury.flickerapp.utility.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
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
        feedsViewModel = ViewModelProviders.of(this,viewModelFactory).get(FeedViewModel::class.java)
        setUpData()
    }

    private fun setUpData() = launch {
        val feeds = feedsViewModel.fetchFeedByTagAsyc("cat").await()
        feeds.observe(this@HomeActivity, Observer {
            if (it == null) return@Observer
            toast("Success")
        })
    }
}
