package com.example.innstantbook.presentation.ui.home.adapter

import com.example.innstantbook.databinding.ClientItemBinding
import com.example.innstantbook.databinding.HotelItemBinding
import com.example.innstantbook.networking.model.ClientResponse
import com.example.innstantbook.networking.model.HotelResponse
import com.example.innstantbook.presentation.adapters.CustomBindingViewHolder
import com.example.innstantbook.presentation.models.MenuType

class ClientsViewHolder(
    private val binding: ClientItemBinding,
    private val onItemClick: ((MenuType) -> Unit)
) : CustomBindingViewHolder<ClientResponse>(binding) {

    override fun bind(item: ClientResponse, position: Int) {
        binding.clientName.text = item.name

        binding.clientEmail.text = item.email
    }
}