package com.example.isnews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.isnews.Model.Article
import com.squareup.picasso.Picasso

class CustomAdapter(private var mList: ArrayList<Article>, private  val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = mList[position].title
        val url = if (mList[position].urlToImage.isNullOrEmpty())  "https://picsum.photos/200/300/?blur=2" else mList[position].urlToImage
        Picasso.get().load(url).into(holder.imageView)
        holder.date.text = mList[position].publishedAt
        holder.author.text = mList[position].author

        holder.itemView.setOnClickListener(
            View.OnClickListener {
                onItemClickListener.onItemClickListener(position) }
        )

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val  date : TextView = itemView.findViewById(R.id.date)
        val  author : TextView = itemView.findViewById(R.id.author)
    }
}
