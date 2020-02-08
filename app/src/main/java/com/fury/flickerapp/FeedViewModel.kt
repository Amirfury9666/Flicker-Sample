package com.fury.flickerapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fury.flickerapp.db.FeedEntry
import com.fury.flickerapp.repository.FlickerRepository
import com.fury.flickerapp.utility.lazyDeferred
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FeedViewModel(private val flickerRepository : FlickerRepository) : ViewModel(){


    fun fetchFeedByTagAsyc(tag : String) : Deferred<LiveData<FeedEntry>>{
        val feeds by lazyDeferred {
            flickerRepository.getFeedByTag(tag)
        }

        return feeds
    }

    fun loadFeedByTag(tag: String){
        GlobalScope.launch {
            flickerRepository.loadFeed(tag)
        }
    }
}