package com.farahani.elmira.bitcoinpredictor

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.row_item.view.*


class BitcoinDaysAdapter (val numbersList:ArrayList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = numbersList.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.textViewBitcoinDaysCount.text = numbersList[position]
    }

    internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var item: TextView

        init {
            itemView.setOnClickListener(this)
            item = itemView.textViewBitcoinDaysCount
        }

        override fun onClick(view: View) {
            Log.d("onclick", "onClick " + layoutPosition + " " + item.text)
        }
    }
}