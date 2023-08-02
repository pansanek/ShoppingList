package com.potemkin.shoppinglist.presentation

import android.app.Application
import com.potemkin.shoppinglist.di.DaggerApplicationComponent

class ShopApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}