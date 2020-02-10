package com.fury.flickerapp.base.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fury.flickerapp.data.viewmodel.FeedViewModel
import com.fury.flickerapp.data.repository.FlickerRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val flickerRepository: FlickerRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  FeedViewModel(flickerRepository) as T
    }
}