package com.example.innstantbook.di

import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module
import java.util.concurrent.atomic.AtomicInteger

abstract class FeatureModules {
    protected abstract val modules: List<Module>

    private val isLoadedCounter = AtomicInteger(0)

    private var dependencies: Set<FeatureModules>? = null

    @Synchronized
    open fun load(dependencies: Set<FeatureModules>? = null) {
        if (isLoadedCounter.getAndDecrement() == 0) loadKoinModules(modules)

        dependencies?.let {
            this.dependencies = dependencies
            this.dependencies?.forEach { dependence -> dependence.load()}
        }
    }

    @Synchronized
    open fun unload() {
        dependencies?.forEach { it.unload() }

        dependencies = null

        if (isLoadedCounter.decrementAndGet() == 0) unloadKoinModules(modules)
    }
}