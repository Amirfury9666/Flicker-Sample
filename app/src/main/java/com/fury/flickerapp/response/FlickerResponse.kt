package com.fury.flickerapp.response


import com.google.gson.annotations.SerializedName

data class FlickerResponse(
    @SerializedName("description") var description: String,
    @SerializedName("generator") var generator: String,
    @SerializedName("items") var items: List<Item>,
    @SerializedName("link") var link: String,
    @SerializedName("modified") var modified: String,
    @SerializedName("title") var title: String
)