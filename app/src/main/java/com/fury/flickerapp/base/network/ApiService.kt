package com.fury.flickerapp.base.network

import com.fury.flickerapp.response.FlickerResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("feeds/photos_public.gne")
    fun getFeedsAsync(
        @Query("tags") tag:String,
        @Query("nojsoncallback") nojsoncallback:Int,
        @Query("per_page") itemCount: Int,
        @Query("format") format:String
    ): Deferred<FlickerResponse>

}
