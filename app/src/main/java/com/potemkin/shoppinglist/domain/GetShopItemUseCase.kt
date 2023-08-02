package com.potemkin.shoppinglist.domain

import javax.inject.Inject

class GetShopItemUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository
) {
    suspend fun getShopItem(ShopItemId: Int): ShopItem{
        return shopListRepository.getShopItem(ShopItemId)
    }
}