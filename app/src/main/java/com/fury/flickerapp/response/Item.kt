package com.fury.flickerapp.response


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "flicker_feed")
data class Item(
    @SerializedName("link") var link: String,
    @SerializedName("author") var author: String,
    @SerializedName("author_id") var authorId: String,
    @SerializedName("date_taken") var dateTaken: String,
    @SerializedName("description") var description: String,
    @Embedded(prefix = "media_")
    @SerializedName("media") var media: Media,
    @SerializedName("published") var published: String,
    @SerializedName("tags") var tags: String,
    @SerializedName("title") var title: String
){
    @PrimaryKey
    var tag : String = ""
}