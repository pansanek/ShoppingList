package com.potemkin.shoppinglist.domain

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(ShopItemId: Int): ShopItem

    fun getShopList(): List<ShopItem>
}