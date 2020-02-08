package com.fury.flickerapp.repository

import androidx.lifecycle.LiveData
import com.fury.flickerapp.db.FeedEntry

interface FlickerRepository {
    suspend fun loadFeed(tag : String)
    suspend fun getFeedByTag(tag: String) : LiveData<FeedEntry>
}