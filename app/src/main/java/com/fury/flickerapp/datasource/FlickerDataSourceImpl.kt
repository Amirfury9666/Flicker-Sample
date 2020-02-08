package com.fury.flickerapp.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fury.flickerapp.base.network.ApiService
import com.fury.flickerapp.db.FeedEntry
import com.fury.flickerapp.response.Item
import timber.log.Timber
import java.lang.Exception

class FlickerDataSourceImpl(private val apiService: ApiService) : FlickerDataSource {

    private val _downloadedFeeds = MutableLiveData<FeedEntry>()

    override val downloadedFeeds: LiveData<FeedEntry>
        get() = _downloadedFeeds

    override suspend fun fetchFeedsByTag(tag: String) {
        try {
            var feedResponse = apiService.getFeedsAsync(tag,1,50,"json").await()
            val feedEntry = FeedEntry(tag = tag)
            feedEntry.feeds = feedResponse.items
            feedResponse.items.forEach {
                feedEntry.link = it.link
            }
            _downloadedFeeds.postValue(feedEntry)
        }catch (e : Exception){
            Timber.d(e.message)
        }
    }
}