package com.example.innstantbook.presentation.ui.home.adapter

import com.example.innstantbook.databinding.HotelItemBinding
import com.example.innstantbook.databinding.MenuItemBinding
import com.example.innstantbook.networking.model.HotelsResponse
import com.example.innstantbook.presentation.adapters.CustomBindingViewHolder
import com.example.innstantbook.presentation.extensions.clickWithDebounce
import com.example.innstantbook.presentation.models.MenuItem
import com.example.innstantbook.presentation.models.MenuType
import com.example.innstantbook.presentation.components.menu.HorizontalMenuView

class HotelsViewHolder(
    private val binding: HotelItemBinding,
    private val onItemClick: ((MenuType) -> Unit)
) : CustomBindingViewHolder<HotelsResponse>(binding) {

    override fun bind(item: HotelsResponse, position: Int) {
        binding.hotelName.text = item.name

        binding.hotelAddress.text = item.address
    }
}