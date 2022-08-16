package com.example.isnews.Model

data class NewsResponse(
    val articles: ArrayList<Article>,
    val status: String,
    val totalResults: Int
)