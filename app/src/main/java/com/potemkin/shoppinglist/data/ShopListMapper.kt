package com.potemkin.shoppinglist.data

import com.potemkin.shoppinglist.domain.ShopItem
import javax.inject.Inject

class ShopListMapper @Inject constructor() {

    fun mapEntityToDbModel(shopItem: ShopItem)= ShopItemDBModel(
        shopItem.id,
        shopItem.name,
        shopItem.count,
        shopItem.enabled
    )

    fun mapDbModelToEntity(shopItemDBModel: ShopItemDBModel)= ShopItem(
        shopItemDBModel.name,
        shopItemDBModel.count,
        shopItemDBModel.enabled,
        shopItemDBModel.id
    )

    fun mapListDbModelToListEntity(list:List<ShopItemDBModel>) = list.map {
        mapDbModelToEntity(it)
    }
}