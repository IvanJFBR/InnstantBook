package com.example.innstantbook

import com.example.innstantbook.di.InnstantBookModules
import com.example.innstantbook.extensions.startKoin
import com.example.innstantbook.shared.Trace

class InnstantBookApplication : android.app.Application() {
    override fun onCreate(): Unit = Trace.traceBlock("AppOnCreate") {
        Trace.traceBlock("AppSuperOnCreate") {
            super.onCreate()
        }

        startKoin()
        InnstantBookModules.load()
    }
}