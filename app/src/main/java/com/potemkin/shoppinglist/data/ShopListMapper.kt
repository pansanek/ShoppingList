package com.potemkin.shoppinglist.data

import com.potemkin.shoppinglist.domain.ShopItem

class ShopListMapper {

    fun mapEntityToDbModel(shopItem: ShopItem)= ShopItemDBModel(
        shopItem.id,
        shopItem.name,
        shopItem.count,
        shopItem.enabled
    )

    fun mapDbModelToEntity(shopItemDBModel: ShopItemDBModel)= ShopItem(
        shopItemDBModel.id,
        shopItemDBModel.name,
        shopItemDBModel.count,
        shopItemDBModel.enabled
    )

    fun mapListDbModelToListEntity(list:List<ShopItemDBModel>) = list.map {
        mapDbModelToEntity(it)
    }
}