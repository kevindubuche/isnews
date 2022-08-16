package com.example.isnews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.isnews.API.NewsAPI
import com.example.isnews.API.RetrofitInstance
import com.example.isnews.Model.Article
import com.example.isnews.Model.NewsResponse
import com.example.isnews.Model.Source
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), OnItemClickListener {

    lateinit var recyclerview: RecyclerView
    lateinit var loadingPB: ProgressBar
    lateinit var recyclerviewAdapter: CustomAdapter
    lateinit var articles: ArrayList<Article>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview = findViewById(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        loadingPB = findViewById(R.id.idPBLoading)
        articles = ArrayList()
        getAllArticles(this)

    }
    private fun getAllArticles(onItemClickListener: OnItemClickListener) {
        val retrofitAPI = RetrofitInstance.api

        // on below line we are calling a method to get all the courses from API.
        val call: Call<NewsResponse> = retrofitAPI.getBreakingNews()

        // on below line we are calling method to enqueue and calling
        // all the data from array list.
        call!!.enqueue(object : Callback<NewsResponse?> {
            override fun onResponse(
                call: Call<NewsResponse?>,
                response: Response<NewsResponse?>
            ) {
                if (response.isSuccessful) {
                    loadingPB.visibility = View.GONE
                    articles = response.body()?.articles!!
                }
                 // on below line we are initializing our adapter.
                  recyclerviewAdapter = CustomAdapter(articles, onItemClickListener)
                // on below line we are setting adapter to recycler view.
                recyclerview.adapter = recyclerviewAdapter
                recyclerviewAdapter.notifyDataSetChanged()



            }

            override fun onFailure(call: Call<NewsResponse?>, t: Throwable) {
                // displaying an error message in toast
                Toast.makeText(this@MainActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    override fun onItemClickListener(position: Int) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("title", articles[position].title)
        intent.putExtra("author", articles[position].author)
        intent.putExtra("description", articles[position].description)
        intent.putExtra("content", articles[position].content)
        intent.putExtra("publishedAt", articles[position].publishedAt)
        intent.putExtra("urlToImage", articles[position].urlToImage)
        intent.putExtra("url", articles[position].url)
        startActivity(intent)
    }

}
