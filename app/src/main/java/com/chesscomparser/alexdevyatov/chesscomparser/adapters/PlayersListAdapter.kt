package com.chesscomparser.alexdevyatov.chesscomparser.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chesscomparser.alexdevyatov.chesscomparser.R
import com.chesscomparser.alexdevyatov.chesscomparser.model.Player

class PlayersListAdapter(val values: List<Player>, val listener: OnItemClickListener) :
        RecyclerView.Adapter<PlayersListAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: Player)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayersListAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_player, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: PlayersListAdapter.ViewHolder, position: Int) {
        holder.bind(values[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null
        init {
            textView = itemView.findViewById(R.id.tv_player_name)
        }

        fun bind(player: Player, listener: OnItemClickListener) {
            textView?.text = player.nickname
            itemView.setOnClickListener {
                listener.onItemClick(player)
            }
        }
    }

}