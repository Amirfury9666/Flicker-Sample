package com.fury.flickerapp.db

import androidx.room.TypeConverter
import com.fury.flickerapp.response.Item
import com.fury.flickerapp.utility.fromJson
import com.fury.flickerapp.utility.json
import com.google.gson.Gson

class FeedConverter {

    @TypeConverter
    fun converToString(list : List<Item>?) : String{
        list ?: return ""
        return list.json()
    }

    @TypeConverter
    fun converToFeed(value : String?) : List<Item>{
        if (value.isNullOrEmpty()){
            return arrayListOf()
        }
        return Gson().fromJson<ArrayList<Item>>(value)
    }
}