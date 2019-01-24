package com.example.rviciana.inngame.presentation

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rviciana.inngame.R
import com.example.rviciana.inngame.domain.bo.Trailer
import com.example.rviciana.inngame.extensions.inflate

class TrailerListAdapter : RecyclerView.Adapter<ViewHolder>() {

    private var trailers: MutableList<Trailer> = ArrayList()

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(parent.inflate(R.layout.trailer_item_layout))

    override fun getItemCount(): Int = trailers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)  =
            holder.bind(trailers[position])

    fun setTrailers(trailers: List<Trailer>) {
        this.trailers.addAll(trailers)
        notifyDataSetChanged()
    }

    fun addTrailer(trailer: Trailer) {
        this.trailers.add(trailer)
        notifyItemChanged(this.trailers.size)
    }

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(trailer: Trailer) = with(itemView) {

    }

}
