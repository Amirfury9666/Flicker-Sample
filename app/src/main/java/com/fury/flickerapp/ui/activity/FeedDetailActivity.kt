package com.fury.flickerapp.ui.activity

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.fury.flickerapp.R
import com.fury.flickerapp.base.core.BaseActivity
import com.fury.flickerapp.databinding.ActivityFeedDetailBinding
import com.fury.flickerapp.utility.ImageLoader

class FeedDetailActivity : BaseActivity<ActivityFeedDetailBinding>() {

    override val layoutResId: Int get() = R.layout.activity_feed_detail

    override fun getToolBar(binding: ActivityFeedDetailBinding): Toolbar? {return null}

    override fun onActivityReady(instance: Bundle?, binding: ActivityFeedDetailBinding) {
        intent?.let {
            var image = it.getStringExtra("image")
            val title = it.getStringExtra("title")
            ImageLoader.loadFeedImage(binding.image,image)
            binding.title.text = title
        }
    }


}
