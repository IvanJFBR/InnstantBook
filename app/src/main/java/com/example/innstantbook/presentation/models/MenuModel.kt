package com.example.innstantbook.presentation.models

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes

data class Menu(
    val items: List<MenuItem>
)

data class MenuItem(
    val title: String,
    @DrawableRes
    val image: Int,
    val type: MenuType
)

enum class MenuType {
    HOTELS,
    CLIENTS,
    ROOMS,
    RATINGS,
    BOOKINGS
}