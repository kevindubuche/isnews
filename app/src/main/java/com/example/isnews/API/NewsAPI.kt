package com.example.isnews.API

import com.example.isnews.Model.NewsResponse
import com.example.isnews.Util.Constant
import com.example.isnews.Util.Constant.Companion.API_KEY
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("top-headlines")
    fun getBreakingNews(
        @Query("country")
        countryCode: String = "fr",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Call<NewsResponse>
}