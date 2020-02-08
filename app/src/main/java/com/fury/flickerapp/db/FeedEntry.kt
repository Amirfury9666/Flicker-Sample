package com.fury.flickerapp.db

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.fury.flickerapp.response.Item

@Entity(indices = arrayOf(Index(value = ["tag"],unique = true)))
data class FeedEntry(
    @PrimaryKey(autoGenerate = false)
    var link: String = "",
    var tag: String = "",
    @TypeConverters(FeedConverter::class)
    var feeds: List<Item> = listOf()
)