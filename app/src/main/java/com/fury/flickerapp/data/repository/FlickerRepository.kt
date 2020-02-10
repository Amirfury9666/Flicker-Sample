package com.fury.flickerapp.data.repository

import androidx.lifecycle.LiveData
import com.fury.flickerapp.data.db.FeedEntry

interface FlickerRepository {
    suspend fun loadFeed(tag : String)
    suspend fun getFeedByTag(tag: String) : LiveData<FeedEntry>
}