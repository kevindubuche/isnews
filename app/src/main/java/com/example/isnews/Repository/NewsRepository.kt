package com.example.isnews.Repository

import com.example.isnews.API.RetrofitInstance

class NewsRepository {

    suspend fun getBreakingNews(countyCode: String, pageNumber: Int)=
        RetrofitInstance.api.getBreakingNews(countyCode,pageNumber)

}