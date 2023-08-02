package com.potemkin.shoppinglist.di

import android.app.Activity
import android.app.Application
import android.provider.ContactsContract.Data
import com.potemkin.shoppinglist.presentation.MainActivity
import com.potemkin.shoppinglist.presentation.ShopItemFragment
import dagger.BindsInstance
import dagger.Component
import dagger.Component.Factory

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: ShopItemFragment)

    @dagger.Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}