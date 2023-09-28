package com.example.innstantbook.presentation.components.menu

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.innstantbook.R
import com.example.innstantbook.databinding.HorizontalMenuViewLayoutBinding
import com.example.innstantbook.databinding.MenuItemBinding
import com.example.innstantbook.presentation.adapters.CustomListAdapter
import com.example.innstantbook.presentation.adapters.HorizontalMenuViewHolder
import com.example.innstantbook.presentation.extensions.getLayoutInflater
import com.example.innstantbook.presentation.extensions.viewBinding
import com.example.innstantbook.presentation.models.Menu
import com.example.innstantbook.presentation.models.MenuItem
import com.example.innstantbook.presentation.models.MenuType

class HorizontalMenuView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding by viewBinding {
        HorizontalMenuViewLayoutBinding.inflate(getLayoutInflater(), this, true)
    }

    var menu: Menu? = null
        set(value) {
            field = value
            value?.setup(value.items)
        }

    var onMenuClick: ((MenuType) -> Unit) = {}

    private fun Menu.setup(items: List<MenuItem>) {
        binding.rvMenus.apply {
            adapter = object : CustomListAdapter<MenuItem, HorizontalMenuViewHolder>() {
                override fun getViewHolderInstance(
                    parent: ViewGroup,
                    viewType: Int
                ): HorizontalMenuViewHolder {
                    return HorizontalMenuViewHolder(
                        MenuItemBinding.inflate(
                            LayoutInflater.from(parent.context), parent, false
                        )
                    ) {
                        onMenuClick(it)
                    }
                }
            }.apply {
                contentList = items
            }
        }
    }
}