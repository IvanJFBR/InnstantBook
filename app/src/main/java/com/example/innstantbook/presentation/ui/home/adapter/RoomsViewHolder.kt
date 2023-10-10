package com.example.innstantbook.presentation.ui.home.adapter

import android.content.res.ColorStateList
import android.view.View
import androidx.core.view.ViewCompat
import com.example.innstantbook.R
import com.example.innstantbook.databinding.RoomItemBinding
import com.example.innstantbook.networking.model.RoomResponse
import com.example.innstantbook.presentation.adapters.CustomBindingViewHolder
import com.example.innstantbook.presentation.models.MenuType

class RoomsViewHolder(
    private val binding: RoomItemBinding,
    private val onItemClick: ((MenuType) -> Unit)
) : CustomBindingViewHolder<RoomResponse>(binding) {

    override fun bind(item: RoomResponse, position: Int): Unit = with(binding) {
        roomNumber.text = "quarto ${item.number.toString()}"
        roomPrice.text = "R$ ${item.price}"
        roomStatus.apply {
            when (item.status) {
                1 -> {
                    text = "Disponível"
                    setBgColor(
                        ColorStateList.valueOf(resources.getColor(R.color.tag_open, null))
                    )
                }
                2 -> {
                    text = "Reservado"
                    setBgColor(
                        ColorStateList.valueOf(resources.getColor(R.color.tag_closed, null))
                    )
                }
                else -> {
                    text = "Manutenção"
                    setBgColor(
                        ColorStateList.valueOf(resources.getColor(R.color.gray_400, null))
                    )
                }
            }
        }
    }

    private fun View.setBgColor(color: ColorStateList) {
        ViewCompat.setBackgroundTintList(
            this,
            color
        )
    }
}