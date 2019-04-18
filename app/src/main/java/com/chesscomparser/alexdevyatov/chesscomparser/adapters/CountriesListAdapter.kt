package com.chesscomparser.alexdevyatov.chesscomparser.adapters

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.chesscomparser.alexdevyatov.chesscomparser.model.Country
import android.view.LayoutInflater
import android.widget.TextView
import com.chesscomparser.alexdevyatov.chesscomparser.R
import android.support.v4.view.ViewCompat.setRotationY
import android.support.v4.view.ViewCompat.setRotationX
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.animation.LinearInterpolator
import android.support.v4.view.ViewCompat.animate
import android.R.attr.rotationX
import android.R.attr.rotationY
import android.content.Context
import android.view.animation.AnimationUtils


class CountriesListAdapter(val context: Context, val values: List<Country>, val listener: OnItemClickListener) :
        RecyclerView.Adapter<CountriesListAdapter.ViewHolder>() {


    interface OnItemClickListener {
        fun onItemClick(item: Country)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_country, parent, false)
        return ViewHolder(context, itemView)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder : ViewHolder, position : Int) {
        holder.bind(values[position], listener)
    }

    class ViewHolder(val context: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null
        init {
            textView = itemView.findViewById(R.id.tv_country_name)
        }

        fun bind(country: Country, listener: OnItemClickListener) {
            textView?.text = country.name
            itemView.setOnClickListener {
                listener.onItemClick(country)
            }
        }

    }

}