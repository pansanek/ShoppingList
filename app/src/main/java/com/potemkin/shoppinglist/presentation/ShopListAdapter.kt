package com.potemkin.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.potemkin.shoppinglist.R
import com.potemkin.shoppinglist.domain.ShopItem

class ShopListAdapter: RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var shopList = listOf<ShopItem>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    class ShopItemViewHolder(val view: View) :RecyclerView.ViewHolder(view){
        val tvName=view.findViewById<TextView>(R.id.tv_name)
        val tvCount=view.findViewById<TextView>(R.id.tv_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_shop_disabled,
            parent,
            false
        )
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem=shopList[position]
        holder.view.setOnLongClickListener { true }
        if (shopItem.enabled){
            holder.tvName.text=shopItem.name
            holder.tvCount.text=shopItem.count.toString()
            holder.tvName.setTextColor(ContextCompat.getColor(holder.view.context,android.R.color.holo_red_dark))
        }
    }

    override fun onViewRecycled(holder: ShopItemViewHolder) {
        super.onViewRecycled(holder)
        holder.tvName.text=""
        holder.tvCount.text=""
    }

    override fun getItemCount(): Int {
        return shopList.size
    }
}