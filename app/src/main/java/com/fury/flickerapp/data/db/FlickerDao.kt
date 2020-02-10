package com.fury.flickerapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import org.jetbrains.annotations.NotNull

@Dao

interface FlickerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(feedEntry : FeedEntry) : Long

    @NotNull
    @Query("SELECT * FROM FeedEntry WHERE tag =:tag")
    fun getFeedsByTag(tag : String) : LiveData<FeedEntry>

    @Query("DELETE FROM FeedEntry WHERE tag = :tag")
    fun deleteAllFeeds(tag : String)
}