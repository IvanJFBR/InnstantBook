package com.example.innstantbook.presentation.extensions

import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding

private const val DEFAULT_DEBOUNCE_MILLIS = 500L
fun View.clickWithDebounce(debounceTime: Long = DEFAULT_DEBOUNCE_MILLIS, action: () -> Unit) {
    this.setOnClickListener(object : OnClickListener {
        private var lastClickTime: Long = 0

        override fun onClick(v: View?) {
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
            else action()

            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}

fun AppCompatTextView.setupUsingTest(text: String?) {
    if (text == null) {
        this.isVisible = false
    } else {
        this.isVisible = true
        this.text = text
    }
}