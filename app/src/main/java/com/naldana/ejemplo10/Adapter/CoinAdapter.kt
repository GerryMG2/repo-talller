package com.naldana.ejemplo10.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naldana.ejemplo10.R
import com.naldana.ejemplo10.Utilities.Coin

class CoinAdapter (var movies: MutableList<Coin>, val clickListener: (Coin) -> Unit): RecyclerView.Adapter<CoinAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): CoinAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.coin_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = movies.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position],clickListener)

    fun changeList(movies: MutableList<Coin>){
        this.movies = movies

        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(item: Coin,clickListener: (Coin) -> Unit)= with(itemView){
            /*Glide.with(itemView.context)
                .load(item.Poster)
                .placeholder(R.drawable.ic_launcher_background)
                .into(movie_image_cv)

            movie_title_cv.text = item.Title
            movie_plot_cv.text = item.Plot
            movie_rate_cv.text = item.imdbRating
            movie_runtime_cv.text = item.Runtime
            this.setOnClickListener{clickListener(item)}*/
        }
    }
}
