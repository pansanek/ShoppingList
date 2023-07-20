package com.potemkin.shoppinglist.presentation

import android.util.Log
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
    var count = 0
    var shopList = listOf<ShopItem>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    var onShopItemLongClickListener:((ShopItem)->Unit)? = null
    var onShopItemClickListener:((ShopItem)->Unit)? = null

    class ShopItemViewHolder(val view: View) :RecyclerView.ViewHolder(view){
        val tvName=view.findViewById<TextView>(R.id.tv_name)
        val tvCount=view.findViewById<TextView>(R.id.tv_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        Log.d("ShopListAdapter","OnCreate,count:${++count}")
        val layout = when (viewType){
            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
            else -> throw java.lang.RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(
            layout,
            parent,
            false
        )
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem=shopList[position]
        holder.view.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        holder.view.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
        }
        holder.tvName.text=shopItem.name
        holder.tvCount.text=shopItem.count.toString()
    }

    override fun getItemViewType(position: Int): Int {
        val item = shopList[position]
        return if (item.enabled){
            VIEW_TYPE_ENABLED
        }else {
            VIEW_TYPE_DISABLED
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

    companion object{
        const val VIEW_TYPE_ENABLED = 0
        const val VIEW_TYPE_DISABLED = 1

        const val MAX_POOL_SIZE=15
    }
}