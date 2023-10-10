package com.example.innstantbook.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.innstantbook.R
import com.example.innstantbook.databinding.ActivityHomeBinding
import com.example.innstantbook.databinding.ClientItemBinding
import com.example.innstantbook.databinding.HotelItemBinding
import com.example.innstantbook.databinding.RoomItemBinding
import com.example.innstantbook.networking.model.ClientResponse
import com.example.innstantbook.networking.model.HotelResponse
import com.example.innstantbook.networking.model.RoomResponse
import com.example.innstantbook.presentation.adapters.CustomListAdapter
import com.example.innstantbook.presentation.models.Menu
import com.example.innstantbook.presentation.models.MenuItem
import com.example.innstantbook.presentation.models.MenuType
import com.example.innstantbook.presentation.ui.home.adapter.ClientsViewHolder
import com.example.innstantbook.presentation.ui.home.adapter.HotelsViewHolder
import com.example.innstantbook.presentation.ui.home.adapter.RoomsViewHolder

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

    fun setContent(data: HomeModel) = with(binding) {
        rvHotels.apply {
            adapter = object : CustomListAdapter<HotelResponse, HotelsViewHolder>() {
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
                val showHotelSection = data.hotels.isNotEmpty()
                hotelListTitle.isVisible = showHotelSection
                hotelsDivider.isVisible = showHotelSection
                contentList = data.hotels
            }
        }

        rvRooms.apply {
            adapter = object : CustomListAdapter<RoomResponse, RoomsViewHolder>() {
                override fun getViewHolderInstance(
                    parent: ViewGroup,
                    viewType: Int
                ): RoomsViewHolder {
                    return RoomsViewHolder(
                        RoomItemBinding.inflate(
                            LayoutInflater.from(parent.context), parent, false
                        )
                    ) {

                    }
                }
            }.apply {
                roomsListTitle.isVisible = data.rooms.isNotEmpty()
                contentList = data.rooms
            }
        }
    }
}