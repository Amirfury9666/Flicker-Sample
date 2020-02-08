package com.fury.flickerapp.repository

import androidx.lifecycle.LiveData
import com.fury.flickerapp.datasource.FlickerDataSource
import com.fury.flickerapp.db.FeedEntry
import com.fury.flickerapp.db.FlickerDao
import com.github.ajalt.timberkt.d
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FlickerRepositoryImpl(private val dao : FlickerDao,private val  flickerDataSource : FlickerDataSource) : FlickerRepository {

    init {
        flickerDataSource.downloadedFeeds.observeForever {
            persistFetchFeeds(it)
        }
    }
    override suspend fun loadFeed(tag: String) {
        flickerDataSource.fetchFeedsByTag(tag)
    }

    override suspend fun getFeedByTag(tag: String): LiveData<FeedEntry> {
        return withContext(Dispatchers.IO){
            return@withContext dao.getFeedsByTag(tag)
        }
    }

    private fun persistFetchFeeds(feed : FeedEntry){
        GlobalScope.launch(Dispatchers.IO){
            dao.deleteAllFeeds(feed.tag)
            dao.insert(feed)
        }
    }
}