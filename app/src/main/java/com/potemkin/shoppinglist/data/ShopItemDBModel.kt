package com.potemkin.shoppinglist.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.potemkin.shoppinglist.domain.ShopItem

@Entity(tableName = "shop_items")
data class ShopItemDBModel(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val name:String,
    val count:Int,
    val enabled: Boolean
)