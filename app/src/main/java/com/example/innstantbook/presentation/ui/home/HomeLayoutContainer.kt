package com.example.innstantbook.presentation.ui.home

import com.example.innstantbook.R
import com.example.innstantbook.databinding.ActivityHomeBinding
import com.example.innstantbook.presentation.models.Menu
import com.example.innstantbook.presentation.models.MenuItem
import com.example.innstantbook.presentation.models.MenuType

class HomeLayoutContainer(
    private val binding: ActivityHomeBinding
) {

    fun init() = with(binding) {
        toolbar.title = "InnstantBook"
        homeMenu.menu = Menu(
            items = listOf(
                MenuItem(
                    title = "Hoteis",
                    image = R.drawable.ic_hotel,
                    type = MenuType.HOTELS
                ),
                MenuItem(
                    title = "Clientes",
                    image = R.drawable.ic_clients,
                    type = MenuType.CLIENTS
                ),
                MenuItem(
                    title = "Quartos",
                    image = R.drawable.ic_room,
                    type = MenuType.ROOMS
                ),
                MenuItem(
                    title = "Avaliações",
                    image = R.drawable.ic_rating,
                    type = MenuType.RATINGS
                ),
                MenuItem(
                    title = "Reservas",
                    image = R.drawable.ic_ticket,
                    type = MenuType.BOOKINGS
                )
            )
        )
    }
}