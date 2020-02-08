package com.fury.flickerapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fury.flickerapp.response.Item

@Database(entities = [FeedEntry::class],version = 1,exportSchema = false)
@TypeConverters(FeedConverter::class)
abstract class FlickerDatabase : RoomDatabase(){

    abstract fun getFlickerDao() : FlickerDao
    companion object {
        private var instance : FlickerDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)  = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it }
        }
        private fun buildDatabase(context: Context): FlickerDatabase {
            return Room.databaseBuilder(context.applicationContext,FlickerDatabase::class.java,"flicker.db").build()
        }
    }

}