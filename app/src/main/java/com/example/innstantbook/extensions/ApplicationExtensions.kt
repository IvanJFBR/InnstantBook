package com.example.innstantbook.extensions

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module

fun Application.startKoin() = org.koin.core.context.startKoin {
    androidContext(this@startKoin)
}