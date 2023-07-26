package com.potemkin.shoppinglist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun getShopItem(ShopItemId: Int): ShopItem{
        return shopListRepository.getShopItem(ShopItemId)
    }
}