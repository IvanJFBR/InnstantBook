package com.example.innstantbook.presentation.components.app_bar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.innstantbook.R
import com.example.innstantbook.databinding.AppBarViewLayoutBinding

class AppBarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = AppBarViewLayoutBinding.inflate(
        LayoutInflater.from(this.context),
        this
    )

    var title: String = ""
        set(value) {
            binding.title.text = value
            field = value
        }
}