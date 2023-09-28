package com.example.innstantbook.shared

import java.util.concurrent.ConcurrentHashMap

interface Trace {
    val name: String

    companion object {
        private val traceNameToTraceMap = ConcurrentHashMap<String, Trace>()

        inline fun <T> traceBlock(name: String, block: Trace.() -> T): T {
            val trace: Trace = TraceImpl(name)
            trace.start()
            try {
                return block(trace)
            } finally {
                trace.stop()
            }
        }
    }

    fun start()

    fun stop()
}

class TraceImpl(override val name: String) : Trace {
    override fun start() {
        android.os.Trace.beginSection(name)
    }

    override fun stop() {
        android.os.Trace.endSection()
    }
}