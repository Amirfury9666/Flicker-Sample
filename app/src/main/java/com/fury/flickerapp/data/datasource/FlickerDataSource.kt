package com.fury.flickerapp.data.datasource

import androidx.lifecycle.LiveData
import com.fury.flickerapp.data.db.FeedEntry

interface FlickerDataSource {
    val downloadedFeeds : LiveData<FeedEntry>
    suspend fun fetchFeedsByTag(tag : String)
}