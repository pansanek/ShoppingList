package com.potemkin.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.potemkin.shoppinglist.data.ShopListRepositoryImpl
import com.potemkin.shoppinglist.domain.*

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopListUseCase = DeleteShopItemUseCase(repository)
    private val editShopListUseCase = EditShopItemUseCase(repository)

}