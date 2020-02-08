package com.fury.flickerapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fury.flickerapp.repository.FlickerRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val flickerRepository: FlickerRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  FeedViewModel(flickerRepository) as T
    }
}