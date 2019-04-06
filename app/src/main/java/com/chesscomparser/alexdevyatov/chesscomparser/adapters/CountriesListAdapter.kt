package com.chesscomparser.alexdevyatov.chesscomparser.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.chesscomparser.alexdevyatov.chesscomparser.model.Country
import android.view.LayoutInflater
import android.widget.TextView
import com.chesscomparser.alexdevyatov.chesscomparser.R


class CountriesListAdapter(val values: List<Country>) :
        RecyclerView.Adapter<CountriesListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_country, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder : ViewHolder, position : Int) {
        holder.textView?.text = values[position].name
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null
        init {
            textView = itemView.findViewById(R.id.tv_country_name)
        }
    }

}