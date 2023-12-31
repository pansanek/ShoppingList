package com.potemkin.shoppinglist.di

import android.app.Application
import com.potemkin.shoppinglist.data.AppDatabase
import com.potemkin.shoppinglist.data.ShopListDao
import com.potemkin.shoppinglist.data.ShopListRepositoryImpl
import com.potemkin.shoppinglist.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideShopListDao(
            application: Application
        ): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}