package com.fury.flickerapp.datasource

import androidx.lifecycle.LiveData
import com.fury.flickerapp.db.FeedEntry
import com.fury.flickerapp.response.Item

interface FlickerDataSource {
    val downloadedFeeds : LiveData<FeedEntry>
    suspend fun fetchFeedsByTag(tag : String)
}