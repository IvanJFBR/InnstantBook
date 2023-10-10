package com.example.innstantbook.presentation.ui.home.adapter

import com.example.innstantbook.databinding.HotelItemBinding
import com.example.innstantbook.networking.model.HotelResponse
import com.example.innstantbook.presentation.adapters.CustomBindingViewHolder
import com.example.innstantbook.presentation.extensions.setupUsingTest
import com.example.innstantbook.presentation.models.MenuType

class HotelsViewHolder(
    private val binding: HotelItemBinding,
    private val onItemClick: ((MenuType) -> Unit)
) : CustomBindingViewHolder<HotelResponse>(binding) {

    override fun bind(item: HotelResponse, position: Int) = with(binding) {
        hotelName.setupUsingTest(item.name)
        hotelAddress.setupUsingTest(item.address)
        hotelScore.setupUsingTest(item.score)
        hotelRatingQuantity.setupUsingTest(item.ratingQuantity)
        hotelAvailableRooms.setupUsingTest(item.availableRooms)
    }
}