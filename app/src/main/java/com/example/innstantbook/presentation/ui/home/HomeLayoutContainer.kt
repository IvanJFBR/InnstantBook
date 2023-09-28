package com.example.innstantbook.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.innstantbook.R
import com.example.innstantbook.databinding.ActivityHomeBinding
import com.example.innstantbook.databinding.HotelItemBinding
import com.example.innstantbook.databinding.MenuItemBinding
import com.example.innstantbook.networking.model.HotelsResponse
import com.example.innstantbook.presentation.adapters.CustomListAdapter
import com.example.innstantbook.presentation.adapters.HorizontalMenuViewHolder
import com.example.innstantbook.presentation.models.Menu
import com.example.innstantbook.presentation.models.MenuItem
import com.example.innstantbook.presentation.models.MenuType
import com.example.innstantbook.presentation.ui.home.adapter.HotelsViewHolder

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

    fun setContent(hotels: List<HotelsResponse>) {
        binding.rvHotels.apply {
            adapter = object : CustomListAdapter<HotelsResponse, HotelsViewHolder>() {
                override fun getViewHolderInstance(
                    parent: ViewGroup,
                    viewType: Int
                ): HotelsViewHolder {
                    return HotelsViewHolder(
                        HotelItemBinding.inflate(
                            LayoutInflater.from(parent.context), parent, false
                        )
                    ) {

                    }
                }
            }.apply {
                contentList = hotels
            }
        }
    }
}