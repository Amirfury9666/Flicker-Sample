package com.fury.flickerapp.utility

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.fury.flickerapp.R

object ImageLoader {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadFeedImage(view  : ImageView,url : String?){
        url?.let {
            Glide.with(view.context).load(it).placeholder(R.color.grayColor).into(view)
        }
    }
}