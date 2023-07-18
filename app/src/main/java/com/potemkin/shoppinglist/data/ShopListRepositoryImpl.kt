package com.potemkin.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.potemkin.shoppinglist.domain.ShopItem
import com.potemkin.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl:ShopListRepository {

    private val shopListLiveData = MutableLiveData<List<ShopItem>>()
    private val shopList= sortedSetOf<ShopItem>({ p0, p1 -> p0.id.compareTo(p1.id) })

    private var autoIncrementId =0

    init{
        for(i in 0 until 1000){
            val item = ShopItem("Name $i",i,true)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(ShopItemId: Int): ShopItem {
        return shopList.find {
            it.id == ShopItemId
        } ?: throw java.lang.RuntimeException("Element with id $ShopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLiveData
    }

    private fun updateList(){
        shopListLiveData.value = shopList.toList()
    }

}