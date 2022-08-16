package com.example.isnews

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso

class DetailsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details)

        val  detailsTitle : TextView = this.findViewById(R.id.detailsTitle)
        detailsTitle.text = intent.getStringExtra("title")

        val  detailsImg : ImageView = this.findViewById(R.id.detailsImg)
        Picasso.get().load(intent.getStringExtra("urlToImage")).into(detailsImg)

        val  detailsAuthor : TextView = this.findViewById(R.id.detailsAuthor)
        detailsAuthor.text = intent.getStringExtra("author")

        val  detailsDesc : TextView = this.findViewById(R.id.detailsDesc)
        detailsDesc.text = intent.getStringExtra("description")

        val  detailsContent : TextView = this.findViewById(R.id.detailsContent)
        detailsContent.text = intent.getStringExtra("content")

        val  publishedAt : TextView = this.findViewById(R.id.detailsDate)
        publishedAt.text = intent.getStringExtra("publishedAt")

        val  detailsUrl : TextView = this.findViewById(R.id.detailsUrl)
        detailsUrl.text = intent.getStringExtra("url")
    }
}