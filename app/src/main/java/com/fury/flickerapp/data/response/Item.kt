package com.fury.flickerapp.data.response


import android.content.Intent
import android.view.View
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fury.flickerapp.ui.activity.FeedDetailActivity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "flicker_feed")
data class Item (
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
) {
    @PrimaryKey
    var tag : String = ""

    fun onItemClick(view : View){
        Intent(view.context,FeedDetailActivity::class.java).also {
            it.putExtra("image",media.m)
            it.putExtra("title",title)
            view.context?.startActivity(it)
        }
    }
}