package com.potemkin.shoppinglist.presentation

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("errorInputName")
fun bindErrorInputName(textInputLayout: TextInputLayout,isError: Boolean){
    val message = if (isError) {
        "Ошибка"
    } else {
        null
    }
    textInputLayout.error = message
}

@BindingAdapter("errorInputCount")
fun bindErrorInputCount(textInputLayout: TextInputLayout,isError: Boolean){
    val message = if (isError) {
        "Ошибка"
    } else {
        null
    }
    textInputLayout.error = message
}