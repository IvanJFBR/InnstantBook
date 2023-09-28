package com.example.innstantbook.presentation.adapters

import com.example.innstantbook.databinding.MenuItemBinding
import com.example.innstantbook.presentation.extensions.clickWithDebounce
import com.example.innstantbook.presentation.models.MenuItem
import com.example.innstantbook.presentation.models.MenuType
import com.example.innstantbook.presentation.components.menu.HorizontalMenuView

class HorizontalMenuViewHolder(
    private val binding: MenuItemBinding,
    private val onMenuItemClick: ((MenuType) -> Unit)
) : CustomBindingViewHolder<MenuItem>(binding) {

    override fun bind(item: MenuItem, position: Int) {
        binding.llContainer.apply {
            clickWithDebounce {
                onMenuItemClick(item.type)
            }
        }

        binding.menuImage.setImageResource(item.image)

        binding.menuTitle.text = item.title
    }
}